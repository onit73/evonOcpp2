package kr.dbinc.evon.ocpp.component;

import java.util.concurrent.TimeoutException;

import kr.dbinc.evon.ocpp.types.ResponseType;

public interface ResultStore {

    void addResult(String uniqueId, ResponseType payload);
    ResponseType getResult(String uniqueId);
    boolean isExist(String uniqueId);
}
