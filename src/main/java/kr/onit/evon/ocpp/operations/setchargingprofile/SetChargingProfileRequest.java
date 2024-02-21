package kr.onit.evon.ocpp.operations.setchargingprofile;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.dto.ChargingProfileDto;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SetChargingProfileRequest implements RequestType {

    private final Integer connectorId;
    private final ChargingProfileDto csChargingProfiles;

}
