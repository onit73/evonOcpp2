package kr.onit.evon.ocpp.operations.cancelreservation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.CancelReservationStatus;
import lombok.*;

@Getter
public class CancelReservationResponse implements ResponseType {

    private final CancelReservationStatus status;

    @JsonCreator
    public CancelReservationResponse(
            @JsonProperty(value = "status", required = true) CancelReservationStatus status
    ) {
        this.status = status;
    }
}
