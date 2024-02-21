package kr.onit.evon.ocpp.rpc.exception;

import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 내부 오류가 발생해 receiver가 요청된 작업을 처리할 수 없음
 */
public class InternalErrorException extends CallErrorException{

    public InternalErrorException() {
    }

    public InternalErrorException(String message) {
        super(message, ErrorCode.InternalError);
    }

    public InternalErrorException(String message, Throwable cause) {
        super(message, cause, ErrorCode.InternalError);
    }
}
