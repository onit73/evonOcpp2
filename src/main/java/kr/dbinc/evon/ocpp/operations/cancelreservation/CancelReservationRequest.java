package kr.dbinc.evon.ocpp.operations.cancelreservation;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CancelReservationRequest implements RequestType {

    private final Long reservationId;

}
