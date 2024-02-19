package kr.dbinc.evon.ocpp.profile;

import kr.dbinc.evon.ocpp.web.dto.GetLocalListVersionDto;
import kr.dbinc.evon.ocpp.web.dto.SendLocalListDto;

public interface LocalAuthListManagementProfile extends Profile{

    String getLocalListVersion(GetLocalListVersionDto request);
    String sendLocalList(SendLocalListDto request);
}
