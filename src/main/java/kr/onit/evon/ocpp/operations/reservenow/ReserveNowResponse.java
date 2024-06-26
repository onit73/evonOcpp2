package kr.onit.evon.ocpp.operations.reservenow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.domain.reservation.ReservationStatus;
import kr.onit.evon.ocpp.types.ResponseType;
import lombok.Getter;

@Getter
public class ReserveNowResponse implements ResponseType {

    private final ReservationStatus status;

    @JsonCreator
    public ReserveNowResponse(
            @JsonProperty(value = "status", required = true) ReservationStatus status
    ) {
        this.status = status;
    }
}
