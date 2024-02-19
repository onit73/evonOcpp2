package kr.dbinc.evon.ocpp.operations.getcompositeschedule;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.ChargingRateUnitType;
import lombok.*;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetCompositeScheduleRequest implements RequestType {

    private final Integer connectorId;
    private final Integer duration;
    private final ChargingRateUnitType chargingRateUnit;

}
