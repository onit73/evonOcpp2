package kr.dbinc.evon.ocpp.rpc;

import kr.dbinc.evon.ocpp.rpc.message.CallResult;

public interface ResultHandler {

    void handleResult(CallResult result);
}
