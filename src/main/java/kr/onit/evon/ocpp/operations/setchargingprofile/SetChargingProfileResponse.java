package kr.onit.evon.ocpp.operations.setchargingprofile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.ChargingProfileStatus;
import lombok.Getter;

@Getter
public class SetChargingProfileResponse implements ResponseType {

    private final ChargingProfileStatus status;

    @JsonCreator
    public SetChargingProfileResponse(
            @JsonProperty(value = "status", required = true) ChargingProfileStatus status
    ) {
        this.status = status;
    }
}
