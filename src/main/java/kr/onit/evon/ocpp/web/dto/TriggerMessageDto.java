package kr.onit.evon.ocpp.web.dto;

import kr.onit.evon.ocpp.types.enums.MessageTrigger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TriggerMessageDto extends BaseDto{
    private MessageTrigger requestedMessage;
    private Integer connectorId;
}
