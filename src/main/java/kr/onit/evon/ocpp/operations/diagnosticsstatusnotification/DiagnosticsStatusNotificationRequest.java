package kr.onit.evon.ocpp.operations.diagnosticsstatusnotification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.DiagnosticsStatus;
import lombok.Getter;

@Getter
public class DiagnosticsStatusNotificationRequest implements RequestType {
    private final DiagnosticsStatus status;

    @JsonCreator
    public DiagnosticsStatusNotificationRequest(
            @JsonProperty(value = "status", required = true) DiagnosticsStatus status
    ) {
        this.status = status;
    }
}
