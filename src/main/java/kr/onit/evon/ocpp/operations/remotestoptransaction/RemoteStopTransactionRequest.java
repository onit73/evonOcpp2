package kr.onit.evon.ocpp.operations.remotestoptransaction;

import kr.onit.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RemoteStopTransactionRequest implements RequestType {

    private final Long transactionId;

}
