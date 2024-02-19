package kr.dbinc.evon.ocpp.rpc.exception;

import kr.dbinc.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 액션용 페이로드가 구문적으로 잘못되었거나 액션용 PDU가 구조를 준수하지 않음
 */
public class FormationViolationException extends CallErrorException{


    public FormationViolationException() {
    }

    public FormationViolationException(String message) {
        super(message, ErrorCode.FormationViolation);
    }
}
