package kr.onit.evon.ocpp.operations.changeconfiguration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.ConfigurationStatus;
import lombok.Getter;

@Getter
public class ChangeConfigurationResponse implements ResponseType {
    private final ConfigurationStatus status;

    @JsonCreator
    public ChangeConfigurationResponse(
            @JsonProperty(value = "status", required = true)ConfigurationStatus status
    ) {
        this.status = status;
    }
}
