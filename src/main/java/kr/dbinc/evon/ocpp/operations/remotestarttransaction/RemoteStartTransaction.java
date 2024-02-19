package kr.dbinc.evon.ocpp.operations.remotestarttransaction;

import kr.dbinc.evon.ocpp.types.IdToken;
import kr.dbinc.evon.ocpp.web.dto.RemoteStartTransactionDto;
import lombok.Getter;

@Getter
public class RemoteStartTransaction {

    private final IdToken idTag;
    private final int connectorId;

    public RemoteStartTransaction(RemoteStartTransactionDto request){
        this.idTag = new IdToken(request.getIdTag());
        this.connectorId = request.getConnectorId();
    }

    public static RemoteStartTransaction fromRequest(RemoteStartTransactionDto request) {
        return new RemoteStartTransaction((request));
    }
}
