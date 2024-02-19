package kr.dbinc.evon.ocpp.web.dto;

import kr.dbinc.evon.ocpp.types.enums.ChargingRateUnitType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCompositeScheduleDto extends BaseDto{

    private Integer connectorId;
    private Integer duration;
    private ChargingRateUnitType chargingRateUnit;
}
