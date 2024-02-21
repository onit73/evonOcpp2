package kr.onit.evon.ocpp.operations.clearcache;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.ClearCacheStatus;
import lombok.Getter;

@Getter
public class ClearCacheResponse implements ResponseType {
    private final ClearCacheStatus status;

    @JsonCreator
    public ClearCacheResponse(
            @JsonProperty(value = "status", required = true) ClearCacheStatus status
    ) {
        this.status = status;
    }
}
