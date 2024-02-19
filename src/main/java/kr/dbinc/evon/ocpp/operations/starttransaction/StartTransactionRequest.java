package kr.dbinc.evon.ocpp.operations.starttransaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@ToString
public class StartTransactionRequest implements RequestType {
    private final Integer connectorId;
    private final String idTag;
    private final Integer meterStart;
    private final Long reservationId;
    private final ZonedDateTime timestamp;

    @JsonCreator
    public StartTransactionRequest(
            @JsonProperty(value = "connectorId", required = true)Integer connectorId,
            @JsonProperty(value = "idTag", required = true)String idTag,
            @JsonProperty(value = "meterStart", required = true)Integer meterStart,
            @JsonProperty(value = "reservationId") Long reservationId,
            @JsonProperty(value = "timestamp", required = true)ZonedDateTime timestamp) {
        this.connectorId = connectorId;
        this.idTag = idTag;
        this.meterStart = meterStart;
        this.reservationId = reservationId;
        this.timestamp = timestamp;
    }
}
