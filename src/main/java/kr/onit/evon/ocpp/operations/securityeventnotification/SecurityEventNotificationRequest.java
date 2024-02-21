package kr.onit.evon.ocpp.operations.securityeventnotification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.RequestType;
import lombok.Getter;

@Getter
public class SecurityEventNotificationRequest implements RequestType {
    private final String type;
    private final String timestamp;
    private final String techInfo;

    @JsonCreator
    public SecurityEventNotificationRequest(
            @JsonProperty(value = "type", required = true) String type,
            @JsonProperty(value = "timestamp", required = true) String timestamp,
            @JsonProperty(value = "techInfo") String techInfo) {
        this.type = type;
        this.timestamp = timestamp;
        this.techInfo = techInfo;
    }
}
