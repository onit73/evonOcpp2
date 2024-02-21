package kr.onit.evon.ocpp.rpc;

import com.fasterxml.jackson.core.JsonParser;

import kr.onit.evon.ocpp.rpc.exception.FormationViolationException;
import kr.onit.evon.ocpp.rpc.exception.InternalErrorException;
import kr.onit.evon.ocpp.rpc.exception.NotImplementedException;
import kr.onit.evon.ocpp.rpc.message.Message;
import kr.onit.evon.ocpp.rpc.message.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class MessageFactoryImpl implements MessageFactory{

    private final CallFactory callFactory;

    public MessageFactoryImpl(CallFactory callFactory) {
        this.callFactory = callFactory;
    }

    public Message createMessage(JsonParser parser) {
        try{
            MessageType type = getMessageType(parser);

            if (type == MessageType.CALL) {
                return callFactory.createCall(parser);
            }else if(type == MessageType.CALL_RESULT){
                return callFactory.createCallResult(parser);
            }else if(type == MessageType.CALL_ERROR){
                return callFactory.createCallError(parser);
            }else{
                throw new NotImplementedException("지원되지 않는 Message Type입니다. type = " + type );
            }
        }catch (IOException e){
            log.error(e.getMessage(), e);
            throw new InternalErrorException("Message 처리 중에 에러가 발생했습니다.");
        }

    }

    private static MessageType getMessageType(JsonParser parser) throws IOException {
        parser.nextToken();
        parser.nextToken();
        int type = parser.getIntValue();
        return MessageType.fromInteger(type).orElseThrow( () -> new NotImplementedException("지원되지 않는 Message Type입니다. type = " + type ));
    }

}
