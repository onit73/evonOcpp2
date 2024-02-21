package kr.onit.evon.ocpp.types.dto;

import kr.onit.evon.ocpp.types.IdTagInfo;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthorizationDataDto {

    private String idTag;
    private IdTagInfo idTagInfo;
}
