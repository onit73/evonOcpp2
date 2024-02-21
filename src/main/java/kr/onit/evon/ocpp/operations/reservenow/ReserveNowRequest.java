package kr.onit.evon.ocpp.operations.reservenow;

import lombok.*;

import java.time.ZonedDateTime;

import kr.onit.evon.ocpp.types.RequestType;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReserveNowRequest implements RequestType {

    private final Integer connectorId;
    private final ZonedDateTime expiryDate;
    private final String idTag;
    private final String parentIdTag;
    private final Long reservationId;

}
