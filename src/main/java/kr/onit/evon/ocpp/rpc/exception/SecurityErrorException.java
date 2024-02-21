package kr.onit.evon.ocpp.rpc.exception;


import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 작업 처리 중 보안 문제가 발생하여 receiver가 작업을 성공적으로 완료할 수 없음
 */
public class SecurityErrorException extends CallErrorException{

    public SecurityErrorException() {
    }

    public SecurityErrorException(String message) {
        super(message, ErrorCode.SecurityError);
    }
}
