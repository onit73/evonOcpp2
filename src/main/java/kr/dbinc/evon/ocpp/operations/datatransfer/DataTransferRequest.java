package kr.dbinc.evon.ocpp.operations.datatransfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class DataTransferRequest implements RequestType {
    private final String vendorId;
    private final String messageId;
    private final String data;

    @JsonCreator
    private DataTransferRequest(
            @JsonProperty(value = "vendorId", required = true) String vendorId,
            @JsonProperty(value = "messageId") String messageId,
            @JsonProperty(value = "data") String data) {
        this.vendorId = vendorId;
        this.messageId = messageId;
        this.data = data;
    }
}
