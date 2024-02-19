package kr.dbinc.evon.ocpp.operations.remotestarttransaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.ocpp.types.enums.RemoteStartStopStatus;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RemoteStartTransactionResponse implements ResponseType {
    private final RemoteStartStopStatus status;

    @JsonCreator
    public RemoteStartTransactionResponse(
            @JsonProperty(value = "status", required = true) RemoteStartStopStatus status
    ) {
        this.status = status;
    }
}
