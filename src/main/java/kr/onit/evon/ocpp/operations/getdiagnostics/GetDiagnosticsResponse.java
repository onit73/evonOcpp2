package kr.onit.evon.ocpp.operations.getdiagnostics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import lombok.Getter;

@Getter
public class GetDiagnosticsResponse implements ResponseType {

    private final String fileName;

    @JsonCreator
    public GetDiagnosticsResponse(
            @JsonProperty(value = "fileName") String fileName
    ) {
        this.fileName = fileName;
    }
}
