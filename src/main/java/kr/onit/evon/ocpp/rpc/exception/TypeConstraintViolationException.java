

package kr.onit.evon.ocpp.rpc.exception;


import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 액션용 페이로드가 구문적으로는 올바르지만 필드 중 하나 이상이 데이터 형식 제약 조건을 위반
 */
public class TypeConstraintViolationException extends CallErrorException{

    public TypeConstraintViolationException() {
    }

    public TypeConstraintViolationException(String message) {
        super(message, ErrorCode.TypeConstraintViolation);
    }
}
