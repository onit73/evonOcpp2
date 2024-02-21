package kr.onit.evon.ocpp.operations.changeavailability;

import kr.onit.evon.ocpp.types.enums.AvailabilityType;
import kr.onit.evon.ocpp.web.dto.ChangeAvailabilityDto;
import lombok.Getter;

@Getter
public class ChangeAvailability {

    private final Integer connectorId;
    private final AvailabilityType type;

    private ChangeAvailability(ChangeAvailabilityDto params){
        this.connectorId = params.getConnectorId();
        this.type = AvailabilityType.fromString(params.getType());
    }

    public static ChangeAvailability fromRequest(ChangeAvailabilityDto request) {
        return new ChangeAvailability(request);
    }

}
