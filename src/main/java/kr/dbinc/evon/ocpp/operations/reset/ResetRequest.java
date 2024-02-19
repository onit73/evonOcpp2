package kr.dbinc.evon.ocpp.operations.reset;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.ResetType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResetRequest implements RequestType {
    private ResetType type;

}
