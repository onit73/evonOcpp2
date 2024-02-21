package kr.onit.evon.ocpp.operations.unlockconnector;

import kr.onit.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UnlockConnectorRequest implements RequestType {
    private final Integer connectorId;

}
