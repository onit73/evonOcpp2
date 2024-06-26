package kr.onit.evon.ocpp.rpc;

import com.fasterxml.jackson.core.JsonParser;

import kr.onit.evon.ocpp.rpc.message.Call;
import kr.onit.evon.ocpp.rpc.message.CallError;
import kr.onit.evon.ocpp.rpc.message.CallResult;

import java.io.IOException;

public interface CallFactory {

    Call createCall(JsonParser parser) throws IOException;

    CallResult createCallResult(JsonParser parser) throws  IOException;

    CallError createCallError(JsonParser parser) throws  IOException;
}
