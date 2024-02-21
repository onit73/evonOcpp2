package kr.onit.evon.ocpp.rpc.exception;

import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 다른 에러들로 처리되지 않는 기타 에러
 */
public class GenericErrorException extends CallErrorException{

    public GenericErrorException() {
    }

    public GenericErrorException(String message) {
        super(message, ErrorCode.GenericError);
    }
}
