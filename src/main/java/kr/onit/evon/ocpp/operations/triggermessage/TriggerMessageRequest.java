package kr.onit.evon.ocpp.operations.triggermessage;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.MessageTrigger;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TriggerMessageRequest implements RequestType {

    private final MessageTrigger requestedMessage;
    private final Integer connectorId;

}
