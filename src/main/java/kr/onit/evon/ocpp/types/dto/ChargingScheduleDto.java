package kr.onit.evon.ocpp.types.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.enums.ChargingRateUnitType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@Builder
public class ChargingScheduleDto {

    private final Integer duration;
    private final Integer startSchedule;
    private final ChargingRateUnitType chargingRateUnit;
    private final Float minChargingRate;

    private final List<ChargingSchedulePeriodDto> chargingSchedulePeriod;

    @JsonCreator
    private ChargingScheduleDto(
            @JsonProperty(value = "duration") Integer duration,
            @JsonProperty(value = "startSchedule") Integer startSchedule,
            @JsonProperty(value = "chargingRateUnit", required = true) ChargingRateUnitType chargingRateUnit,
            @JsonProperty(value = "minChargingRate") Float minChargingRate,
            @JsonProperty(value = "chargingSchedulePeriod", required = true) List<ChargingSchedulePeriodDto> chargingSchedulePeriod
    ) {
        this.duration = duration;
        this.startSchedule = startSchedule;
        this.chargingRateUnit = chargingRateUnit;
        this.chargingSchedulePeriod = chargingSchedulePeriod;
        this.minChargingRate = minChargingRate;
    }
}
