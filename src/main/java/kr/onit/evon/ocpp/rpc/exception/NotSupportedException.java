

package kr.onit.evon.ocpp.rpc.exception;


import kr.onit.evon.ocpp.rpc.exception.error.ErrorCode;

/**
 * 요청된 액션이 인식은 되지만 receiver에서 지원되지 않음
 */
public class NotSupportedException extends CallErrorException{

    public NotSupportedException() {
    }

    public NotSupportedException(String message) {
        super(message, ErrorCode.NotSupported);
    }
}
