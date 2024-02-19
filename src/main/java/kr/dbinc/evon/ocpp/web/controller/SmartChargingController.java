package kr.dbinc.evon.ocpp.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.dbinc.evon.ocpp.component.ResultStore;
import kr.dbinc.evon.ocpp.operations.clearchargingprofile.ClearChargingProfileResponse;
import kr.dbinc.evon.ocpp.operations.getcompositeschedule.GetCompositeScheduleResponse;
import kr.dbinc.evon.ocpp.operations.setchargingprofile.SetChargingProfileResponse;
import kr.dbinc.evon.ocpp.profile.Ocpp16Service;
import kr.dbinc.evon.ocpp.web.dto.ClearChargingProfileDto;
import kr.dbinc.evon.ocpp.web.dto.GetCompositeScheduleDto;
import kr.dbinc.evon.ocpp.web.dto.SetChargingProfileDto;

import java.util.concurrent.TimeoutException;

@RestController
@RequiredArgsConstructor
public class SmartChargingController {

    private final Ocpp16Service ocpp16Service;
    private final ResultStore resultStore;


    @GetMapping("/setChargingProfile")
    public String setChargingProfile(SetChargingProfileDto request) {
        return ocpp16Service.setChargingProfile(request);
    }

    @GetMapping("/result/setChargingProfile")
    public SetChargingProfileResponse setChargingProfile(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (SetChargingProfileResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/getCompositeSchedule")
    public String getCompositeSchedule(GetCompositeScheduleDto request) {
        return ocpp16Service.getCompositeSchedule(request);
    }

    @GetMapping("/result/getCompositeSchedule")
    public GetCompositeScheduleResponse getCompositeSchedule(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (GetCompositeScheduleResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/clearChargingProfile")
    public String clearChargingProfile(ClearChargingProfileDto request) {
        return ocpp16Service.clearChargingProfile(request);
    }

    @GetMapping("/result/clearChargingProfile")
    public ClearChargingProfileResponse clearChargingProfile(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (ClearChargingProfileResponse) resultStore.getResult(messageId);
    }

}
