package kr.dbinc.evon.ocpp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import kr.dbinc.evon.ocpp.component.ResultStore;
import kr.dbinc.evon.ocpp.operations.deletecertificate.DeleteCertificateResponse;
import kr.dbinc.evon.ocpp.operations.getinstalledcertificateIds.GetInstalledCertificateIdsResponse;
import kr.dbinc.evon.ocpp.operations.getlog.GetLogResponse;
import kr.dbinc.evon.ocpp.operations.installcertificate.InstallCertificateResponse;
import kr.dbinc.evon.ocpp.operations.signedupdatefirmware.SignedUpdateFirmwareResponse;
import kr.dbinc.evon.ocpp.profile.Ocpp16Service;
import kr.dbinc.evon.ocpp.web.dto.*;

import java.util.concurrent.TimeoutException;

@RestController
@RequiredArgsConstructor
public class SecurityController {

    private final Ocpp16Service ocpp16Service;
    private final ResultStore resultStore;

    @GetMapping("/getLog")
    public String getLog(GetLogDto request) {
        return ocpp16Service.getLog(request);
    }

    @GetMapping("/result/getLog")
    public GetLogResponse getLog(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (GetLogResponse) resultStore.getResult(messageId);
    }


    @PostMapping("/installCertificate")
    public String installCertificate(@RequestBody InstallCertificateDto request) {
        return ocpp16Service.installCertificate(request);
    }

    @GetMapping("/result/installCertificate")
    public InstallCertificateResponse installCertificate(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (InstallCertificateResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/getInstalledCertificateIds")
    public String getInstalledCertificateIds(GetInstalledCertificateIdsDto request) {
        return ocpp16Service.getInstalledCertificateIds(request);
    }

    @GetMapping("/result/getInstalledCertificateIds")
    public GetInstalledCertificateIdsResponse getInstalledCertificateIds(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (GetInstalledCertificateIdsResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/deleteCertificate")
    public String deleteCertificate(DeleteCertificateDto request) {
        return ocpp16Service.deleteCertificate(request);
    }

    @GetMapping("/result/deleteCertificate")
    public DeleteCertificateResponse deleteCertificate(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (DeleteCertificateResponse) resultStore.getResult(messageId);
    }

    @PostMapping("/signedUpdateFirmware")
    public String signedUpdateFirmware(@RequestBody SignedUpdateFirmwareDto request) {
        return ocpp16Service.signedUpdateFirmware(request);
    }

    @GetMapping("/result/signedUpdateFirmware")
    public SignedUpdateFirmwareResponse signedUpdateFirmware(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (SignedUpdateFirmwareResponse) resultStore.getResult(messageId);
    }

}
