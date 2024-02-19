package kr.dbinc.evon.ocpp.operations.sendlocallist;

import lombok.*;

import java.util.List;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.dto.AuthorizationDataDto;
import kr.dbinc.evon.ocpp.types.enums.UpdateType;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SendLocalListRequest implements RequestType {
    private final Long listVersion;
    private final List<AuthorizationDataDto> localAuthorizationList;
    private final UpdateType updateType;

}
