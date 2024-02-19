package kr.dbinc.evon.ocpp.operations.setchargingprofile;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.dto.ChargingProfileDto;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SetChargingProfileRequest implements RequestType {

    private final Integer connectorId;
    private final ChargingProfileDto csChargingProfiles;

}
