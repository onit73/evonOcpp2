package kr.dbinc.evon.ocpp.types.dto;

import kr.dbinc.evon.ocpp.types.IdTagInfo;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthorizationDataDto {

    private String idTag;
    private IdTagInfo idTagInfo;
}
