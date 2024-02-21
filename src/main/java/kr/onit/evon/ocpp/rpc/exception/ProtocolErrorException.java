package kr.onit.evon.ocpp.rpc.exception;


import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 액션에 대한 페이로드가 불완전함
 */
public class ProtocolErrorException extends CallErrorException{

    public ProtocolErrorException() {
    }

    public ProtocolErrorException(String message) {
        super(message, ErrorCode.ProtocolError);
    }
}
