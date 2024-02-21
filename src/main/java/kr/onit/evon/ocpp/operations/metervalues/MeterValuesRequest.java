package kr.onit.evon.ocpp.operations.metervalues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.dto.MeterValueRequest;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class MeterValuesRequest implements RequestType {
    private final int connectorId;
    private final Long transactionId;
    private final List<MeterValueRequest> meterValue;

    @JsonCreator
    public MeterValuesRequest(
            @JsonProperty(value = "connectorId", required = true) int connectorId,
            @JsonProperty(value = "transactionId") Long transactionId,
            @JsonProperty(value = "meterValue", required = true) List<MeterValueRequest> meterValue
    ) {
        this.connectorId = connectorId;
        this.transactionId = transactionId;
        this.meterValue = meterValue;
    }
}
