package kr.dbinc.evon.ocpp.operations.getconfiguration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.ResponseType;
import lombok.Getter;

import java.util.List;

@Getter
public class GetConfigurationResponse implements ResponseType {

    private final List<KeyValueResponse> configurationKey;
    private final List<String> unknownKey;

    @JsonCreator
    public GetConfigurationResponse(
            @JsonProperty(value = "configurationKey") List<KeyValueResponse> configurationKey,
            @JsonProperty(value = "unknownKey") List<String> unknownKey) {
        this.configurationKey = configurationKey;
        this.unknownKey = unknownKey;
    }
}
