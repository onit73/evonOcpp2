package kr.onit.evon.ocpp.rpc;

import kr.onit.evon.ocpp.rpc.message.CallResult;

public interface ResultHandler {

    void handleResult(CallResult result);
}
