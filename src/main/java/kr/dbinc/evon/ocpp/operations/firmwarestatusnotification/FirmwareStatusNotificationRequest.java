package kr.dbinc.evon.ocpp.operations.firmwarestatusnotification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.FirmwareStatus;
import lombok.Getter;


@Getter
public class FirmwareStatusNotificationRequest implements RequestType {
    private final FirmwareStatus status;

    @JsonCreator
    public FirmwareStatusNotificationRequest(
            @JsonProperty(value = "status", required = true) FirmwareStatus status
    ) {
        this.status = status;
    }
}
