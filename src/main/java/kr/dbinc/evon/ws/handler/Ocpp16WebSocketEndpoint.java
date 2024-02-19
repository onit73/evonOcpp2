package kr.dbinc.evon.ws.handler;

import com.fasterxml.jackson.core.JsonParser;

import kr.dbinc.evon.ocpp.OcppVersion;
import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.component.Sender;
import kr.dbinc.evon.ocpp.repository.charger.ChargerStatusRepository;
import kr.dbinc.evon.ocpp.rpc.MessageFactory;
import kr.dbinc.evon.ocpp.rpc.MessageHandler;
import kr.dbinc.evon.ocpp.rpc.exception.CallErrorException;
import kr.dbinc.evon.ocpp.rpc.message.*;
import kr.dbinc.evon.ocpp.service.MessageLogService;
import kr.dbinc.evon.session.ChargePointStore;
import kr.dbinc.evon.util.UriUtil;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.*;

@Log4j2
@Component
public class Ocpp16WebSocketEndpoint extends AbstractWebSocketEndpoint implements SubProtocolCapable {

    private final JsonObjectMapper mapper;
    private final MessageHandler messageHandler;
    private final MessageFactory messageFactory;
    private final MessageLogService messageRecordService;
    private final Sender sender;
    private final ThreadLocal<String> chargePointIdStore;
    public Ocpp16WebSocketEndpoint(MessageHandler messageHandler,
                                   MessageFactory messageFactory,
                                   JsonObjectMapper mapper,
                                   ChargePointStore chargePointStore,
                                   MessageLogService messageRecordService,
                                   Sender sender,
                                   ThreadLocal<String> chargePointIdStore,
                                  ChargerStatusRepository chargerStatusRepository
    ) {
        super(chargePointStore, chargerStatusRepository);
        this.messageHandler = messageHandler;
        this.messageFactory = messageFactory;
        this.mapper = mapper;
        this.messageRecordService = messageRecordService;
        this.sender = sender;
        this.chargePointIdStore = chargePointIdStore;
    }

    @Override
    public OcppVersion getVersion() {
        return OcppVersion.V_16;
    }

    @Override
    @NonNull
    public List<String> getSubProtocols() {
        return new ArrayList<>(Collections.singletonList(getVersion().getValue()));
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage webSocketMessage) {
        try(JsonParser parser = mapper.getMapper().getFactory().createParser(webSocketMessage.getPayload())) {
            String chargePointId = UriUtil.INSTANCE.extractChargePointId(session.getUri());
            chargePointIdStore.set(chargePointId);
            messageRecordService.loggingMessage(webSocketMessage.getPayload(), chargePointId);
            Message message = messageFactory.createMessage(parser);
            messageHandler.handleMessage(message, session);
        }catch(Exception e) {
            log.error(e.getMessage(), e);
            if(e instanceof CallErrorException){
                CallErrorException callErrorException = (CallErrorException) e;
                String[] messages = webSocketMessage.getPayload().split(",");
                if(messages[0].contains("2")){ // CALL 메시지라면
                    String uniqueId = messages[1].replaceAll("\"", "");
                    CallError callError = new CallError(uniqueId, callErrorException.getErrorCode(), callErrorException.getMessage());
                    sender.sendResponse(callError, session);
                }
            }
        }finally {
            chargePointIdStore.remove();
        }
    }

    @Override
    public void handlePongMessage(WebSocketSession session) throws IOException {
        log.info("sessionId={} Received pong message", session.getId());
    }
}
