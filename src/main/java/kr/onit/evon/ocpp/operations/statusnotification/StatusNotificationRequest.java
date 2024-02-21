package kr.onit.evon.ocpp.operations.statusnotification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.ChargePointErrorCode;
import kr.onit.evon.ocpp.types.enums.ChargePointStatus;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class StatusNotificationRequest implements RequestType {

    private final Integer connectorId;
    private final ChargePointErrorCode errorCode;
    private final String info;
    private final ChargePointStatus status;
    private final ZonedDateTime timestamp;
    private final String vendorId;
    private final String vendorErrorCode;

    @JsonCreator
    public StatusNotificationRequest(
            @JsonProperty(value = "connectorId", required = true) Integer connectorId,
            @JsonProperty(value = "errorCode", required = true) ChargePointErrorCode errorCode,
            @JsonProperty(value = "info") String info,
            @JsonProperty(value = "status", required = true) ChargePointStatus status,
            @JsonProperty(value = "timestamp") ZonedDateTime timestamp,
            @JsonProperty(value = "vendorId") String vendorId,
            @JsonProperty(value = "vendorErrorCode") String vendorErrorCode
    ) {
        this.connectorId = connectorId;
        this.errorCode = errorCode;
        this.info = info;
        this.status = status;
        this.timestamp = timestamp;
        this.vendorId = vendorId;
        this.vendorErrorCode = vendorErrorCode;
    }
}
