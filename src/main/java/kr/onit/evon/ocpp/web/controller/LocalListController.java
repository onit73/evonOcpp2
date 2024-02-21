package kr.onit.evon.ocpp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.onit.evon.ocpp.component.ResultStore;
import kr.onit.evon.ocpp.operations.getlocallistversion.GetLocalListVersionResponse;
import kr.onit.evon.ocpp.operations.sendlocallist.SendLocalListResponse;
import kr.onit.evon.ocpp.profile.Ocpp16Service;
import kr.onit.evon.ocpp.web.dto.GetLocalListVersionDto;
import kr.onit.evon.ocpp.web.dto.SendLocalListDto;

import java.util.concurrent.TimeoutException;

@RestController
@RequiredArgsConstructor
public class LocalListController {

    private final Ocpp16Service ocpp16Service;
    private final ResultStore resultStore;

    @GetMapping("/getLocalListVersion")
    public String triggerMessage(GetLocalListVersionDto request) {
        return ocpp16Service.getLocalListVersion(request);
    }

    @GetMapping("/result/getLocalListVersion")
    public GetLocalListVersionResponse getLocalListVersion(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (GetLocalListVersionResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/sendLocalList")
    public String sendLocalList(SendLocalListDto request) {
        return ocpp16Service.sendLocalList(request);
    }

    @GetMapping("/result/sendLocalList")
    public SendLocalListResponse sendLocalList(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (SendLocalListResponse) resultStore.getResult(messageId);
    }
}
