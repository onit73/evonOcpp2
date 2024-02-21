package kr.onit.evon.ocpp.profile;

import kr.onit.evon.ocpp.web.dto.ClearChargingProfileDto;
import kr.onit.evon.ocpp.web.dto.GetCompositeScheduleDto;
import kr.onit.evon.ocpp.web.dto.SetChargingProfileDto;

public interface SmartChargingProfile extends Profile{

    // Initiated by Central System
    String clearChargingProfile(ClearChargingProfileDto request);
    String getCompositeSchedule(GetCompositeScheduleDto request);
    String setChargingProfile(SetChargingProfileDto request);
}
