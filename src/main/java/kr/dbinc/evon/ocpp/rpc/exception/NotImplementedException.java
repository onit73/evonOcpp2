package kr.dbinc.evon.ocpp.rpc.exception;


import kr.dbinc.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * receiver에서 요청한 작업을 알 수 없음
 */
public class NotImplementedException extends CallErrorException{

    public NotImplementedException() {
    }

    public NotImplementedException(String message) {
        super(message, ErrorCode.NotImplemented);
    }
}
