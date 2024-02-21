package kr.onit.evon.ocpp.component;

import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.types.RequestType;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class PreviousRequestStoreImpl implements PreviousRequestStore{

    private final ConcurrentHashMap<String, RequestType> requestMap = new ConcurrentHashMap<>();

    @Override
    public void addRequest(String uniqueId, RequestType request){
        requestMap.put(uniqueId, request);
    }


    @Override
    public RequestType getRequest(String uniqueId) {
        return requestMap.get(uniqueId);
    }

    @Override
    public RequestType getRequestAndRemove(String uniqueId) {
        return requestMap.remove(uniqueId);
    }
}
