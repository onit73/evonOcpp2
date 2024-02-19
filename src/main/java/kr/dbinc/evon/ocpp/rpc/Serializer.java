
package kr.dbinc.evon.ocpp.rpc;

import kr.dbinc.evon.ocpp.rpc.message.Call;
import kr.dbinc.evon.ocpp.rpc.message.CallError;
import kr.dbinc.evon.ocpp.rpc.message.CallResult;
import kr.dbinc.evon.ocpp.rpc.message.Message;

public interface Serializer {
    String serialize(Message message);
    String callSerialize(Call message);
    String callResultSerialize(CallResult message);
    String callErrorSerialize(CallError message);
}
