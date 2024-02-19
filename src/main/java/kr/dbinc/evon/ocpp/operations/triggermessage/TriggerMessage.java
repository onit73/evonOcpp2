package kr.dbinc.evon.ocpp.operations.triggermessage;

import kr.dbinc.evon.ocpp.types.enums.MessageTrigger;
import kr.dbinc.evon.ocpp.web.dto.TriggerMessageDto;
import lombok.Getter;

@Getter
public class TriggerMessage {

    private final MessageTrigger requestedMessage;
    private final Integer connectorId;

    private TriggerMessage(TriggerMessageDto request){
        this.requestedMessage = request.getRequestedMessage();
        this.connectorId = request.getConnectorId();
    }

    public static TriggerMessage fromRequest(TriggerMessageDto request) {
        return new TriggerMessage(request);
    }
}
