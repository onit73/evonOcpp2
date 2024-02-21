package kr.onit.evon.ocpp.rpc.message;

import kr.onit.evon.ocpp.types.ResponseType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CallResult implements Message {

    private static final MessageType TYPE = MessageType.CALL_RESULT;
    private final String uniqueId;
    private final ResponseType payload;

    public CallResult(String uniqueId, ResponseType payload){
        this.uniqueId = uniqueId;
        this.payload = payload;
    }

    @Override
    public MessageType getType() {
        return TYPE;
    }
}
