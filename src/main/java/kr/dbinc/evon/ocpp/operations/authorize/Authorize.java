package kr.dbinc.evon.ocpp.operations.authorize;

import kr.dbinc.evon.ocpp.types.IdToken;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Authorize{
    String idTag;

    public static Authorize fromRequest(AuthorizeRequest authorizeRequest){
        return new Authorize(authorizeRequest.getIdTag());
    }

}
