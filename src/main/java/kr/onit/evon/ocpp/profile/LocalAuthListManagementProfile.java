package kr.onit.evon.ocpp.profile;

import kr.onit.evon.ocpp.web.dto.GetLocalListVersionDto;
import kr.onit.evon.ocpp.web.dto.SendLocalListDto;

public interface LocalAuthListManagementProfile extends Profile{

    String getLocalListVersion(GetLocalListVersionDto request);
    String sendLocalList(SendLocalListDto request);
}
