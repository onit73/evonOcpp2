package kr.onit.evon.ocpp.profile;

import kr.onit.evon.ocpp.web.dto.TriggerMessageDto;

public interface RemoteTriggerProfile extends Profile{

    String triggerMessage(TriggerMessageDto request);
}
