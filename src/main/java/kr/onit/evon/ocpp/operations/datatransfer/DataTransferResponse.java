package kr.onit.evon.ocpp.operations.datatransfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.DataTransferStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class DataTransferResponse implements ResponseType {

    private DataTransferStatus status;
    private String data;

    @JsonCreator
    public DataTransferResponse(
             @JsonProperty(value = "status", required = true) DataTransferStatus status,
             @JsonProperty(value = "data") String data) {
        this.status = status;
        this.data = data;
    }
}
