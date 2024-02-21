package kr.onit.evon.ocpp.operations.cancelreservation;

import kr.onit.evon.ocpp.web.dto.CancelReservationDto;
import lombok.Getter;

@Getter
public class CancelReservation {

    private final Long reservationId;

    private CancelReservation(CancelReservationDto request){
        this.reservationId = request.getReservationId();
    }
    public static CancelReservation fromRequest(CancelReservationDto request) {
        return new CancelReservation(request);
    }
}
