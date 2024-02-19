package kr.dbinc.evon.ocpp.rpc;

public class IllegalMessageTypeException extends RuntimeException{

    public IllegalMessageTypeException(int type) {
        super( String.format("알 수 없는 Message Type : [%d]", type) );
    }
}
