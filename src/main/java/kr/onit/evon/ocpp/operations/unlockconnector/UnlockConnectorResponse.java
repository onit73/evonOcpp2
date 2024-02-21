package kr.onit.evon.ocpp.operations.unlockconnector;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.UnlockStatus;
import lombok.Getter;

@Getter
public class UnlockConnectorResponse implements ResponseType {
    private final UnlockStatus status;

    @JsonCreator
    public UnlockConnectorResponse(
            @JsonProperty(value = "status", required = true) UnlockStatus status
    ) {
        this.status = status;
    }
}
