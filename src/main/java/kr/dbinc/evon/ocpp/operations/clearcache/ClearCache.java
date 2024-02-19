package kr.dbinc.evon.ocpp.operations.clearcache;

import kr.dbinc.evon.ocpp.web.dto.ClearCacheDto;


public class ClearCache {

    public ClearCache(ClearCacheDto request){

    }

    public static ClearCache fromRequest(ClearCacheDto request) {
        return new ClearCache(request);
    }
}
