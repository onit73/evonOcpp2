package kr.dbinc.evon.ocpp.types.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SampledValueRequest {
    private final String value;
    private final ReadingContext context;
    private final ValueFormat format;
    private final Measurand measurand;
    private final Phase phase;
    private final Location location;
    private final UnitOfMeasure unit;

    @JsonCreator
    public SampledValueRequest(
            @JsonProperty(value = "value", required = true) String value,
            @JsonProperty(value = "context") ReadingContext context,
            @JsonProperty(value = "format") ValueFormat format,
            @JsonProperty(value = "measurand") Measurand measurand,
            @JsonProperty(value = "phase") Phase phase,
            @JsonProperty(value = "location") Location location,
            @JsonProperty(value = "unit") UnitOfMeasure unit
    ) {
        this.value = value;
        this.context = context;
        this.format = format;
        this.measurand = measurand;
        this.phase = phase;
        this.location = location;
        this.unit = unit;
    }
}
