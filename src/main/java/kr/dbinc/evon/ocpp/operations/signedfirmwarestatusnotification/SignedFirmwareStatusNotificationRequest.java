package kr.dbinc.evon.ocpp.operations.signedfirmwarestatusnotification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.FirmwareStatus;
import kr.dbinc.evon.ocpp.types.enums.SecureFirmwareStatus;
import lombok.Getter;

@Getter
public class SignedFirmwareStatusNotificationRequest implements RequestType {

    private final SecureFirmwareStatus status;
    private final Long requestId;

    @JsonCreator
    public SignedFirmwareStatusNotificationRequest(
            @JsonProperty(value = "status", required = true) SecureFirmwareStatus status,
            @JsonProperty(value = "requestId") Long requestId) {
        this.status = status;
        this.requestId = requestId;
    }
}
