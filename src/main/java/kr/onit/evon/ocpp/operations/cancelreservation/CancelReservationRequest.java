package kr.onit.evon.ocpp.operations.cancelreservation;

import kr.onit.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CancelReservationRequest implements RequestType {

    private final Long reservationId;

}
