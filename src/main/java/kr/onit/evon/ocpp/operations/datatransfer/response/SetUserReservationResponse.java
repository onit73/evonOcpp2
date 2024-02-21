package kr.onit.evon.ocpp.operations.datatransfer.response;

import kr.onit.evon.domain.reservation.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetUserReservationResponse {
    private ReservationStatus status;

}
