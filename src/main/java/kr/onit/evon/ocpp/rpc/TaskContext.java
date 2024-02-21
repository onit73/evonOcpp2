
package kr.onit.evon.ocpp.rpc;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.ResponseType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TaskContext {

    private final String chargePointId;
    private final RequestType request;
    private final ResponseType response;
}
