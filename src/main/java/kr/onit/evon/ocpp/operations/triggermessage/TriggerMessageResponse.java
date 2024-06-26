package kr.onit.evon.ocpp.operations.triggermessage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.TriggerMessageStatus;
import lombok.Getter;

@Getter
public class TriggerMessageResponse implements ResponseType {

    private final TriggerMessageStatus status;

    @JsonCreator
    public TriggerMessageResponse(
            @JsonProperty(value = "status", required = true) TriggerMessageStatus status
    ) {
        this.status = status;
    }
}
