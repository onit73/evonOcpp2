package kr.dbinc.evon.ocpp.profile;

import kr.dbinc.evon.ocpp.web.dto.TriggerMessageDto;

public interface RemoteTriggerProfile extends Profile{

    String triggerMessage(TriggerMessageDto request);
}
