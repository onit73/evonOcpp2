package kr.dbinc.evon.ocpp.operations.stoptransaction;

import kr.dbinc.evon.ocpp.types.IdTagInfo;
import kr.dbinc.evon.ocpp.types.ResponseType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StopTransactionResponse implements ResponseType {
    private IdTagInfo idTagInfo;

}
