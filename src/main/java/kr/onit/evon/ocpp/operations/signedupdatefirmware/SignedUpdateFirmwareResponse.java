package kr.onit.evon.ocpp.operations.signedupdatefirmware;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.UpdateFirmwareStatus;
import lombok.Getter;

@Getter
public class SignedUpdateFirmwareResponse implements ResponseType {

    private final UpdateFirmwareStatus status;

    @JsonCreator
    public SignedUpdateFirmwareResponse(
            @JsonProperty(value = "status", required = true) UpdateFirmwareStatus status) {
        this.status = status;
    }
}
