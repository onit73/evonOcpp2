package kr.dbinc.evon.ocpp.operations.authorize;

import kr.dbinc.evon.ocpp.types.IdTagInfo;
import kr.dbinc.evon.ocpp.types.ResponseType;
import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizeResponse implements ResponseType {

    private IdTagInfo idTagInfo;

}
