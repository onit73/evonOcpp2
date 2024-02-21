package kr.onit.evon.ocpp.operations.changeavailability;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.AvailabilityType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChangeAvailabilityRequest implements RequestType {

    private final Integer connectorId;
    private final AvailabilityType type;

}
