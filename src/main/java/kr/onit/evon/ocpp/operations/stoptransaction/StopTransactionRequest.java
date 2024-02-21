package kr.onit.evon.ocpp.operations.stoptransaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.dto.MeterValueRequest;
import kr.onit.evon.ocpp.types.enums.Reason;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@ToString
public class StopTransactionRequest implements RequestType {
    private final String idTag;
    private final int meterStop;
    private final ZonedDateTime timestamp;
    private final Long transactionId;
    private final Reason reason;
    private final List<MeterValueRequest> transactionData;

    @JsonCreator
    public StopTransactionRequest(
            @JsonProperty(value = "idTag") String idTag,
            @JsonProperty(value = "meterStop", required = true) int meterStop,
            @JsonProperty(value = "timestamp", required = true) ZonedDateTime timestamp,
            @JsonProperty(value = "transactionId", required = true) Long transactionId,
            @JsonProperty(value = "reason") Reason reason,
            @JsonProperty(value = "transactionData") List<MeterValueRequest> transactionData
    ) {
        this.idTag = idTag;
        this.meterStop = meterStop;
        this.timestamp = timestamp;
        this.transactionId = transactionId;
        this.reason = reason;
        this.transactionData = transactionData;
    }
}
