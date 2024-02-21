package kr.onit.evon.ocpp.operations.getcompositeschedule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.dto.ChargingScheduleDto;
import kr.onit.evon.ocpp.types.enums.CompositeScheduleStatus;
import lombok.Getter;

@Getter
public class GetCompositeScheduleResponse implements ResponseType {

    private final CompositeScheduleStatus status;
    private final Integer connectorId;
    private final String scheduleStart;
    private final ChargingScheduleDto chargingSchedule;

    @JsonCreator
    public GetCompositeScheduleResponse(
            @JsonProperty(value = "status", required = true) CompositeScheduleStatus status,
            @JsonProperty(value = "connectorId") Integer connectorId,
            @JsonProperty(value = "scheduleStart") String scheduleStart,
            @JsonProperty(value = "chargingSchedule") ChargingScheduleDto chargingSchedule
    ) {
        this.status = status;
        this.connectorId = connectorId;
        this.scheduleStart = scheduleStart;
        this.chargingSchedule = chargingSchedule;
    }
}
