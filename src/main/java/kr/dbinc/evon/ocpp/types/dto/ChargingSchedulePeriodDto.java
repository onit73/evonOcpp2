package kr.dbinc.evon.ocpp.types.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.domain.profile.SchedulePeriod;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ChargingSchedulePeriodDto {

    private final Integer startPeriod;
    private final Double limit;
    private final Integer numberPhases;

    @JsonCreator
    private ChargingSchedulePeriodDto(
            @JsonProperty(value="startPeriod", required = true) Integer startPeriod,
            @JsonProperty(value="limit", required = true) Double limit,
            @JsonProperty(value="numberPhases") Integer numberPhases
    ) {
        this.startPeriod = startPeriod;
        this.limit = limit;
        this.numberPhases = numberPhases;
    }

    public static List<ChargingSchedulePeriodDto> of(List<SchedulePeriod> schedules){
        return schedules.stream()
                .map(sp -> ChargingSchedulePeriodDto.builder()
                        .startPeriod(sp.getStartPeriod())
                        .limit(sp.getLimit())
                        .numberPhases(sp.getNumberPhase())
                        .build())
                .collect(Collectors.toList());
    }

}
