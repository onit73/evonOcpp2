package kr.dbinc.evon.ocpp.operations.triggermessage;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.MessageTrigger;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TriggerMessageRequest implements RequestType {

    private final MessageTrigger requestedMessage;
    private final Integer connectorId;

}
