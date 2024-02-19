package kr.dbinc.evon.ocpp.types.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@ToString
public class MeterValueRequest {
    private final ZonedDateTime timestamp;
    private final List<SampledValueRequest> sampledValue;

    @JsonCreator
    public MeterValueRequest(
            @JsonProperty(value = "timestamp", required = true) ZonedDateTime timestamp,
            @JsonProperty(value = "sampledValue", required = true) List<SampledValueRequest> sampledValue) {
        this.timestamp = timestamp;
        this.sampledValue = sampledValue;
    }
}
