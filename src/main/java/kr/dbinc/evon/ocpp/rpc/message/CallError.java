package kr.dbinc.evon.ocpp.rpc.message;

import kr.dbinc.evon.ocpp.rpc.exception.error.ErrorCode;
import lombok.Getter;

@Getter
public class CallError implements Message {

    private static final MessageType TYPE = MessageType.CALL_ERROR;
    private final String uniqueId;
    private final ErrorCode errorCode;
    private final String errorDescription;
    // Error Details는 보류

    public CallError(String uniqueId, ErrorCode errorCode, String errorDescription) {
        this.uniqueId = uniqueId;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    @Override
    public MessageType getType() {
        return TYPE;
    }


}
