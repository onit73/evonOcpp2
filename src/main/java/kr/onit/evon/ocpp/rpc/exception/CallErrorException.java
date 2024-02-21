package kr.onit.evon.ocpp.rpc.exception;

import static kr.onit.evon.ocpp.rpc.exception.error.ErrorCode.*;

import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;
import lombok.Getter;

@Getter
public class CallErrorException extends RuntimeException{

    private final ErrorCode errorCode;

    public CallErrorException() {
        this.errorCode = GenericError;
    }

    public CallErrorException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public CallErrorException(String message) {
        super(message);
        this.errorCode = GenericError;
    }

    public CallErrorException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CallErrorException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
