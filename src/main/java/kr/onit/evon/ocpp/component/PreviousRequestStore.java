package kr.onit.evon.ocpp.component;

import kr.onit.evon.ocpp.types.RequestType;

public interface PreviousRequestStore {

    void addRequest(String uniqueId, RequestType request);
    RequestType getRequest(String uniqueId);
    RequestType getRequestAndRemove(String uniqueId);
}
