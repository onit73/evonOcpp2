package kr.dbinc.evon.ocpp.component;

import java.util.Set;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.ResponseType;

public interface TypeStore {

    Class<? extends RequestType> findRequestClass(String action);
    <T extends RequestType> Class<? extends ResponseType> findResponseClass(T requestPayload);

    <INTERFACE> Set<Class<? extends INTERFACE>> findClassesWithInterface(String packageName, Class<INTERFACE> interfaceClass);
}
