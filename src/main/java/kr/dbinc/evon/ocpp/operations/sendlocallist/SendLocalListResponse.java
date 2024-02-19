package kr.dbinc.evon.ocpp.operations.sendlocallist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.ocpp.types.enums.UpdateStatus;
import lombok.Getter;

@Getter
public class SendLocalListResponse implements ResponseType {

    private final UpdateStatus status;

    @JsonCreator
    public SendLocalListResponse(
            @JsonProperty(value = "status", required = true) UpdateStatus status
    ) {
        this.status = status;
    }
}
