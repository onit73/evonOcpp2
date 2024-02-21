package kr.onit.evon.ocpp.component;

import com.fasterxml.uuid.Generators;

import kr.onit.evon.ocpp.rpc.Serializer;
import kr.onit.evon.ocpp.rpc.exception.InternalErrorException;
import kr.onit.evon.ocpp.rpc.message.Call;
import kr.onit.evon.ocpp.rpc.message.Message;
import kr.onit.evon.ocpp.service.MessageLogService;
import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.session.ChargePointStore;
import kr.onit.evon.util.UriUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class Sender {

    private final ChargePointStore chargePointStore;
    private final Serializer serializer;
    private final PreviousRequestStore previousRequestStore;
    private final MessageLogService messageRecordService;


    public String sendRequest(RequestType requestType, String chargePointId) {

        String uuid = Generators.timeBasedGenerator().generate().toString();
        String action = RequestType.extractAction(requestType);
        log.info("Remote Send chargePointId : "+chargePointId);
        WebSocketSession session = chargePointStore.get(chargePointId).getSession();
        Call call = Call.builder()
                .uniqueId(uuid)
                .action(action)
                .payload(requestType)
                .build();

        previousRequestStore.addRequest(uuid, requestType);

        String message = serializer.serialize(call);
        messageRecordService.loggingMessage(message, chargePointId);
        try {
            session.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return uuid;
    }

    public void sendResponse(Message result, WebSocketSession session) {
        String message = serializer.serialize(result);
        messageRecordService.loggingMessage(message, UriUtil.INSTANCE.extractChargePointId(session.getUri()));
        try{
            session.sendMessage(new TextMessage(message));
        } catch (IOException e){
            log.error(e.getMessage(),e );
            throw new InternalErrorException("Message 전송 중에 에러가 발생했습니다.");
        }
    }

}
