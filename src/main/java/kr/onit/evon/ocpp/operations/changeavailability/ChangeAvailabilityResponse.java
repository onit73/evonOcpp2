package kr.onit.evon.ocpp.operations.changeavailability;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.AvailabilityType;
import lombok.Getter;

@Getter
public class ChangeAvailabilityResponse implements ResponseType {
    private final AvailabilityType status;

    @JsonCreator
    public ChangeAvailabilityResponse(
            @JsonProperty(value = "status", required = true)AvailabilityType status
    ) {
        this.status = status;
    }
}
