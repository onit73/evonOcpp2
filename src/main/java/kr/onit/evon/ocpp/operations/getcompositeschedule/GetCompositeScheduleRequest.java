package kr.onit.evon.ocpp.operations.getcompositeschedule;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.ChargingRateUnitType;
import lombok.*;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetCompositeScheduleRequest implements RequestType {

    private final Integer connectorId;
    private final Integer duration;
    private final ChargingRateUnitType chargingRateUnit;

}
