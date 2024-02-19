package kr.dbinc.evon.ocpp.operations.clearchargingprofile;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.ChargingProfilePurposeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClearChargingProfileRequest implements RequestType {

    private final Long id;
    private final Integer connectorId;
    private final ChargingProfilePurposeType chargingProfilePurpose;
    private final Integer stackLevel;

}
