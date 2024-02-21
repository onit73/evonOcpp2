package kr.onit.evon.ocpp.operations.sendlocallist;

import lombok.*;

import java.util.List;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.dto.AuthorizationDataDto;
import kr.onit.evon.ocpp.types.enums.UpdateType;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SendLocalListRequest implements RequestType {
    private final Long listVersion;
    private final List<AuthorizationDataDto> localAuthorizationList;
    private final UpdateType updateType;

}
