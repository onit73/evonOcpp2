package kr.onit.evon.ocpp.operations.remotestoptransaction;

import kr.onit.evon.ocpp.web.dto.RemoteStopTransactionDto;
import lombok.Getter;

@Getter
public class RemoteStopTransaction {

    private final Long transactionId;

    private RemoteStopTransaction(RemoteStopTransactionDto request){
        this.transactionId = request.getTransactionId();
    }

    public static RemoteStopTransaction fromRequest(RemoteStopTransactionDto request) {
        return new RemoteStopTransaction(request);
    }
}
