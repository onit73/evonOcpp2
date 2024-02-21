package kr.onit.evon.ocpp.rpc.exception;


import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 페이로드가 구문적으로는 올바르지만 하나 이상의 필드에 잘못된 값이 포함
 */
public class PropertyConstraintViolationException extends CallErrorException{

    public PropertyConstraintViolationException() {
    }

    public PropertyConstraintViolationException(String message) {
        super(message, ErrorCode.PropertyConstraintViolation);
    }
}
