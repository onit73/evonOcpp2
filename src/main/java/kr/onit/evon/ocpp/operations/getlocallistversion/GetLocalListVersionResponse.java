package kr.onit.evon.ocpp.operations.getlocallistversion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import lombok.Getter;

@Getter
public class GetLocalListVersionResponse implements ResponseType {

    private final Integer listVersion;

    @JsonCreator
    public GetLocalListVersionResponse(
            @JsonProperty(value = "listVersion", required = true) Integer listVersion
    ) {
        this.listVersion = listVersion;
    }
}
