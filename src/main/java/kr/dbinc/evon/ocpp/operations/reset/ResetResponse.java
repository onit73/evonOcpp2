package kr.dbinc.evon.ocpp.operations.reset;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.ocpp.types.enums.ResetStatus;
import lombok.Getter;

@Getter
public class ResetResponse implements ResponseType {
    private final ResetStatus status;

    @JsonCreator
    public ResetResponse(
            @JsonProperty(value = "status", required = true) ResetStatus status
    ) {
        this.status = status;
    }
}
