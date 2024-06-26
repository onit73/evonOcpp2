package kr.onit.evon.ocpp.operations.clearchargingprofile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.ClearChargingProfileStatus;
import lombok.Getter;

@Getter
public class ClearChargingProfileResponse implements ResponseType {
    private final ClearChargingProfileStatus status;

    @JsonCreator
    public ClearChargingProfileResponse(
            @JsonProperty(value = "status", required = true) ClearChargingProfileStatus status
    ) {
        this.status = status;
    }
}
