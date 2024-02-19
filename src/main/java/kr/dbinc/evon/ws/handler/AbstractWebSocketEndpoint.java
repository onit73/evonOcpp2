package kr.dbinc.evon.ws.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.ExceptionWebSocketHandlerDecorator;

import kr.dbinc.evon.ocpp.OcppVersion;
import kr.dbinc.evon.ocpp.repository.charger.ChargerStatusRepository;
import kr.dbinc.evon.session.ChargePointStore;
import kr.dbinc.evon.util.UriUtil;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractWebSocketEndpoint extends ConcurrentWebSocketHandler {

    public abstract OcppVersion getVersion();

    private final ChargePointStore chargePointStore;
    private final UriUtil uriUtil = UriUtil.INSTANCE;
    private final ChargerStatusRepository chargerStatusRepository;

    @Override
    void onMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            handleTextMessage(session, (TextMessage) message);

        } else if (message instanceof   PongMessage) {
            handlePongMessage(session);

        } else if (message instanceof BinaryMessage) {
            session.close(CloseStatus.NOT_ACCEPTABLE.withReason("Binary messages not supported"));
        } else {
            throw new IllegalStateException("Unexpected WebSocket message type: " + message);
        }
    }

    public abstract void handleTextMessage(WebSocketSession session, TextMessage webSocketMessage) throws Exception;

    public abstract void handlePongMessage(WebSocketSession session) throws IOException;

    @Override
    void onOpen(WebSocketSession session) throws Exception {
        
        String chargePointId = uriUtil.extractChargePointId(session.getUri());
        
        log.info("[" + chargePointId + "] is Connected! By remoteAddress : "+session.getRemoteAddress()+"/session:"+session.getId());
        chargePointStore.add(chargePointId, session);
        //Shakehands 후 처리 커넥션상태 변경
        chargerStatusRepository.insertCPConnectionStatus(chargePointId);
    }

    @Override
    void onClose(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        String chargePointId = uriUtil.extractChargePointId(session.getUri());
        log.info("onClose [" + chargePointId + "] is Disconnected! session: "+session.getId());
        //WS Session 종료 후 처리 커넥션상태 변경
        chargerStatusRepository.updateCPConnectionStatus(chargePointId);
        chargePointStore.remove(chargePointId, session);
    }

    @Override
    void onError(WebSocketSession session, Throwable throwable) throws Exception {
        String chargePointId = uriUtil.extractChargePointId(session.getUri());
        log.info("onError [ " + chargePointId + "] is Disconnected! session:"+session.getId());
        chargePointStore.remove(chargePointId, session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
