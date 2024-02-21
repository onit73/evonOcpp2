package kr.onit.evon.ocpp.component;

import java.util.concurrent.TimeoutException;

import kr.onit.evon.ocpp.types.ResponseType;

public interface ResultStore {

    void addResult(String uniqueId, ResponseType payload);
    ResponseType getResult(String uniqueId);
    boolean isExist(String uniqueId);
}
