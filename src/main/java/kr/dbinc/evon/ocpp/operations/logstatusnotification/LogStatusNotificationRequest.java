package kr.dbinc.evon.ocpp.operations.logstatusnotification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.UploadLogStatus;
import lombok.Getter;

@Getter
public class LogStatusNotificationRequest implements RequestType {
    private final UploadLogStatus status;
    private final Long requestId;

    @JsonCreator

    public LogStatusNotificationRequest(
            @JsonProperty(value = "status", required = true) UploadLogStatus status,
            @JsonProperty(value = "requestId", required = false) Long requestId) {
        this.status = status;
        this.requestId = requestId;
    }
}
