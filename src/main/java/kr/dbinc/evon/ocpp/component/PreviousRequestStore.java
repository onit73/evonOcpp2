package kr.dbinc.evon.ocpp.component;

import kr.dbinc.evon.ocpp.types.RequestType;

public interface PreviousRequestStore {

    void addRequest(String uniqueId, RequestType request);
    RequestType getRequest(String uniqueId);
    RequestType getRequestAndRemove(String uniqueId);
}
