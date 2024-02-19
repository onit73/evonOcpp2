package kr.dbinc.evon.ocpp.operations.changeavailability;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.AvailabilityType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChangeAvailabilityRequest implements RequestType {

    private final Integer connectorId;
    private final AvailabilityType type;

}
