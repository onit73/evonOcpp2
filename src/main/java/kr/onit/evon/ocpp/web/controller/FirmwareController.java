package kr.onit.evon.ocpp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.onit.evon.ocpp.component.ResultStore;
import kr.onit.evon.ocpp.operations.getdiagnostics.GetDiagnosticsResponse;
import kr.onit.evon.ocpp.operations.updatefirmware.UpdateFirmwareResponse;
import kr.onit.evon.ocpp.profile.Ocpp16Service;
import kr.onit.evon.ocpp.web.dto.GetDiagnosticsDto;
import kr.onit.evon.ocpp.web.dto.UpdateFirmwareDto;

import java.util.concurrent.TimeoutException;


@RestController
@RequiredArgsConstructor
public class FirmwareController {

    private final Ocpp16Service ocpp16Service;
    private final ResultStore resultStore;


    @GetMapping("/getDiagnostics")
    public String getDiagnostics(GetDiagnosticsDto request) {
        return ocpp16Service.getDiagnostics(request);
    }

    @GetMapping("/result/getDiagnostics")
    public GetDiagnosticsResponse getDiagnostics(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (GetDiagnosticsResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/updateFirmware")
    public String updateFirmware(UpdateFirmwareDto request) {
        return ocpp16Service.updateFirmware(request);
    }

    @GetMapping("/result/updateFirmware")
    public UpdateFirmwareResponse updateFirmware(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (UpdateFirmwareResponse) resultStore.getResult(messageId);
    }
}
