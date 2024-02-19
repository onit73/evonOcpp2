package kr.dbinc.evon.ocpp.component;

import org.springframework.stereotype.Component;

import kr.dbinc.evon.ocpp.exception.TimeoutException;
import kr.dbinc.evon.ocpp.types.ResponseType;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class ResultStoreImpl implements ResultStore{

    private final ConcurrentHashMap<String, ResponseType> responseMap = new ConcurrentHashMap<>();

    @Override
    public void addResult(String uniqueId, ResponseType payload) {
        responseMap.put(uniqueId, payload);
    }


    @Override
    public ResponseType getResult(String uniqueId) {
        for (int i = 0; i < 500 ; i++) {
            if(isExist(uniqueId)){
                return responseMap.remove(uniqueId);
            }
            try {
                Thread.sleep(10); // 0.01초 * 500 = 5초
            } catch (InterruptedException ignore) {
            }
        }
        throw new TimeoutException("요청 시간이 만료되었습니다.");
    }

    @Override
    public boolean isExist(String uniqueId) {
        return responseMap.containsKey(uniqueId);
    }

}
