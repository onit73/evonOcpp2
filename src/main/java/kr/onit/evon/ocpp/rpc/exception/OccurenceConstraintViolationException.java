package kr.onit.evon.ocpp.rpc.exception;


import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 액션에 대한 페이로드가 구문적으로는 올바르지만 필드 중 하나 이상이 occurence constraints를 위반함
 */
public class OccurenceConstraintViolationException extends CallErrorException{

    public OccurenceConstraintViolationException() {
    }

    public OccurenceConstraintViolationException(String message) {
        super(message, ErrorCode.OccurenceConstraintViolation);
    }
}
