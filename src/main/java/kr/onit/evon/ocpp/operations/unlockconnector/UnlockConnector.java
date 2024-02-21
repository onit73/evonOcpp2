package kr.onit.evon.ocpp.operations.unlockconnector;

import kr.onit.evon.ocpp.web.dto.UnlockConnectorDto;
import lombok.Getter;

@Getter
public class UnlockConnector {
    private final int connectorId;

    private UnlockConnector(UnlockConnectorDto request){
        this.connectorId = request.getConnectorId();
    }
    public static UnlockConnector fromRequest(UnlockConnectorDto request) {
        return new UnlockConnector(request);
    }
}
