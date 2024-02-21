package kr.onit.evon.ocpp.operations.authorize;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.RequestType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class AuthorizeRequest implements RequestType {

    private final String idTag;

    @JsonCreator
    public AuthorizeRequest(
            @JsonProperty(value = "idTag", required = true) String idTag
    ){
        this.idTag = idTag;
    }
}
