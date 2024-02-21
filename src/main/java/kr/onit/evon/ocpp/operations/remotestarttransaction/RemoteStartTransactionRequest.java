package kr.onit.evon.ocpp.operations.remotestarttransaction;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.dto.ChargingProfileDto;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RemoteStartTransactionRequest implements RequestType {

    private final int connectorId;
    private final String idTag;
    private final ChargingProfileDto chargingProfile;

}
