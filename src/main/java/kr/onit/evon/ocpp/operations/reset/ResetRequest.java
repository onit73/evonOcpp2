package kr.onit.evon.ocpp.operations.reset;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.ResetType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResetRequest implements RequestType {
    private ResetType type;

}
