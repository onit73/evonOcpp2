package kr.onit.evon.ocpp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.onit.evon.ocpp.component.ResultStore;
import kr.onit.evon.ocpp.operations.triggermessage.TriggerMessageResponse;
import kr.onit.evon.ocpp.profile.Ocpp16Service;
import kr.onit.evon.ocpp.web.dto.TriggerMessageDto;

import java.util.concurrent.TimeoutException;


@RestController
@RequiredArgsConstructor
public class RemoteTriggerController {

    private final Ocpp16Service ocpp16Service;
    private final ResultStore resultStore;

    @GetMapping("/triggerMessage")
    public String triggerMessage(TriggerMessageDto request) {
        return ocpp16Service.triggerMessage(request);
    }

    @GetMapping("/result/remoteTrigger")
    public TriggerMessageResponse triggerMessage(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (TriggerMessageResponse) resultStore.getResult(messageId);
    }

}
