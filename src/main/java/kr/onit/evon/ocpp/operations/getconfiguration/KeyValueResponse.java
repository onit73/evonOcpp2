package kr.onit.evon.ocpp.operations.getconfiguration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.enums.ConfigurationKey;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class KeyValueResponse {

    private final ConfigurationKey key;
    private final Boolean readonly;
    private final String value;

    @JsonCreator
    public KeyValueResponse(
            @JsonProperty(value = "key", required = true) ConfigurationKey key,
            @JsonProperty(value = "readonly", required = true) Boolean readonly,
            @JsonProperty(value = "value") String value) {
        this.key = key;
        this.readonly = readonly;
        this.value = value;
    }
}
