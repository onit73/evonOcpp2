package kr.onit.evon.ocpp.operations.authorize;

import kr.onit.evon.ocpp.types.IdTagInfo;
import kr.onit.evon.ocpp.types.ResponseType;
import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizeResponse implements ResponseType {

    private IdTagInfo idTagInfo;

}
