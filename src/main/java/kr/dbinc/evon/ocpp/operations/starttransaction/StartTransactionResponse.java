package kr.dbinc.evon.ocpp.operations.starttransaction;

import kr.dbinc.evon.ocpp.types.IdTagInfo;
import kr.dbinc.evon.ocpp.types.ResponseType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StartTransactionResponse implements ResponseType {

    private IdTagInfo idTagInfo;
    private Long transactionId;

}
