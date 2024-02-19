package kr.dbinc.evon.ocpp.operations.remotestoptransaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.ocpp.types.enums.RemoteStartStopStatus;
import lombok.Getter;

@Getter
public class RemoteStopTransactionResponse implements ResponseType {

    private final RemoteStartStopStatus status;

    @JsonCreator
    public RemoteStopTransactionResponse(
            @JsonProperty(value = "status", required = true) RemoteStartStopStatus status
    ) {
        this.status = status;
    }
}
