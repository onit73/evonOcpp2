package kr.dbinc.evon.ocpp.profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.dbinc.evon.domain.profile.ChargingProfile;
import kr.dbinc.evon.ocpp.component.Sender;
import kr.dbinc.evon.ocpp.operations.authorize.AuthorizeRequest;
import kr.dbinc.evon.ocpp.operations.authorize.AuthorizeResponse;
import kr.dbinc.evon.ocpp.operations.bootnotification.BootNotificationRequest;
import kr.dbinc.evon.ocpp.operations.bootnotification.BootNotificationResponse;
import kr.dbinc.evon.ocpp.operations.cancelreservation.CancelReservation;
import kr.dbinc.evon.ocpp.operations.cancelreservation.CancelReservationRequest;
import kr.dbinc.evon.ocpp.operations.certificatesigned.CertificateSignedRequest;
import kr.dbinc.evon.ocpp.operations.changeavailability.ChangeAvailability;
import kr.dbinc.evon.ocpp.operations.changeavailability.ChangeAvailabilityRequest;
import kr.dbinc.evon.ocpp.operations.changeconfiguration.ChangeConfigurationRequest;
import kr.dbinc.evon.ocpp.operations.clearcache.ClearCacheRequest;
import kr.dbinc.evon.ocpp.operations.clearchargingprofile.ClearChargingProfileRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.*;
import kr.dbinc.evon.ocpp.operations.deletecertificate.DeleteCertificateRequest;
import kr.dbinc.evon.ocpp.operations.diagnosticsstatusnotification.DiagnosticsStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.diagnosticsstatusnotification.DiagnosticsStatusNotificationResponse;
import kr.dbinc.evon.ocpp.operations.firmwarestatusnotification.FirmwareStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.firmwarestatusnotification.FirmwareStatusNotificationResponse;
import kr.dbinc.evon.ocpp.operations.getcompositeschedule.GetCompositeScheduleRequest;
import kr.dbinc.evon.ocpp.operations.getconfiguration.GetConfiguration;
import kr.dbinc.evon.ocpp.operations.getconfiguration.GetConfigurationRequest;
import kr.dbinc.evon.ocpp.operations.getdiagnostics.GetDiagnosticsRequest;
import kr.dbinc.evon.ocpp.operations.getinstalledcertificateIds.GetInstalledCertificateIdsRequest;
import kr.dbinc.evon.ocpp.operations.getlocallistversion.GetLocalListVersionRequest;
import kr.dbinc.evon.ocpp.operations.getlog.GetLogRequest;
import kr.dbinc.evon.ocpp.operations.heartbeat.HeartbeatRequest;
import kr.dbinc.evon.ocpp.operations.heartbeat.HeartbeatResponse;
import kr.dbinc.evon.ocpp.operations.installcertificate.InstallCertificateRequest;
import kr.dbinc.evon.ocpp.operations.logstatusnotification.LogStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.logstatusnotification.LogStatusNotificationResponse;
import kr.dbinc.evon.ocpp.operations.metervalues.MeterValuesRequest;
import kr.dbinc.evon.ocpp.operations.metervalues.MeterValuesResponse;
import kr.dbinc.evon.ocpp.operations.remotestarttransaction.RemoteStartTransaction;
import kr.dbinc.evon.ocpp.operations.remotestarttransaction.RemoteStartTransactionRequest;
import kr.dbinc.evon.ocpp.operations.remotestoptransaction.RemoteStopTransaction;
import kr.dbinc.evon.ocpp.operations.remotestoptransaction.RemoteStopTransactionRequest;
import kr.dbinc.evon.ocpp.operations.reservenow.ReserveNow;
import kr.dbinc.evon.ocpp.operations.reservenow.ReserveNowRequest;
import kr.dbinc.evon.ocpp.operations.reset.Reset;
import kr.dbinc.evon.ocpp.operations.reset.ResetRequest;
import kr.dbinc.evon.ocpp.operations.securityeventnotification.SecurityEventNotificationRequest;
import kr.dbinc.evon.ocpp.operations.securityeventnotification.SecurityEventNotificationResponse;
import kr.dbinc.evon.ocpp.operations.sendlocallist.SendLocalListRequest;
import kr.dbinc.evon.ocpp.operations.setchargingprofile.SetChargingProfileRequest;
import kr.dbinc.evon.ocpp.operations.signedfirmwarestatusnotification.SignedFirmwareStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.signedfirmwarestatusnotification.SignedFirmwareStatusNotificationResponse;
import kr.dbinc.evon.ocpp.operations.signedupdatefirmware.SignedUpdateFirmwareRequest;
import kr.dbinc.evon.ocpp.operations.starttransaction.StartTransactionRequest;
import kr.dbinc.evon.ocpp.operations.starttransaction.StartTransactionResponse;
import kr.dbinc.evon.ocpp.operations.statusnotification.StatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.statusnotification.StatusNotificationResponse;
import kr.dbinc.evon.ocpp.operations.stoptransaction.StopTransactionRequest;
import kr.dbinc.evon.ocpp.operations.stoptransaction.StopTransactionResponse;
import kr.dbinc.evon.ocpp.operations.triggermessage.TriggerMessage;
import kr.dbinc.evon.ocpp.operations.triggermessage.TriggerMessageRequest;
import kr.dbinc.evon.ocpp.operations.unlockconnector.UnlockConnector;
import kr.dbinc.evon.ocpp.operations.unlockconnector.UnlockConnectorRequest;
import kr.dbinc.evon.ocpp.operations.updatefirmware.UpdateFirmwareRequest;
import kr.dbinc.evon.ocpp.service.*;
import kr.dbinc.evon.ocpp.types.datatype.CertificateHashData;
import kr.dbinc.evon.ocpp.types.datatype.SecureFirmware;
import kr.dbinc.evon.ocpp.types.dto.ChargingProfileDto;
import kr.dbinc.evon.ocpp.web.dto.*;
import kr.dbinc.evon.session.ChargePoint;
import kr.dbinc.evon.util.DateUtil;

import javax.xml.bind.DatatypeConverter;

import static kr.dbinc.evon.ocpp.types.enums.ConfigurationKey.*;

import java.util.Base64;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class Ocpp16ServiceImpl implements Ocpp16Service {

    private final Sender sender;


    private final AuthorizeService authorizeService;
    private final DataTransferService dataTransferService;
    private final MeterValuesService meterValuesService;

    private final ReservationService reservationService;
    private final ChargerStatusService chargerStatusService;
    private final LocalListService localListService;

    private final SmartChargingService smartChargingService;

    private final SecurityLogService securityLogService;
    private final KeyValueService keyValueService;

    private final MessageForwardService forwardService;

    // == Core - 충전기에서 시작되는 메시지 == //

    private final AtomicLong idGenerator = new AtomicLong(0);
    @Override
    public BootNotificationResponse bootNotification(BootNotificationRequest request, ChargePoint chargePoint) {
        return forwardService.bootNotification(request, chargePoint);
    }

    @Override
    public HeartbeatResponse heartbeat(HeartbeatRequest request, ChargePoint chargePoint) {
        return forwardService.heartbeat(request, chargePoint);
    }

    @Override
    public StatusNotificationResponse statusNotification(StatusNotificationRequest request, ChargePoint chargePoint) {
        System.out.println("statusNotification getConnectorId:"+request.getConnectorId());
        forwardService.statusNotification(request, chargePoint);
        return new StatusNotificationResponse();
    }

    @Override
    public AuthorizeResponse authorize(AuthorizeRequest request, ChargePoint chargePoint) {
        return forwardService.authorize(request, chargePoint);
    }

    @Override
    public DataTransferResponse dataTransfer(DataTransferRequest request, ChargePoint chargePoint) {
        DataTransfer dataTransfer = DataTransfer.fromRequest(request);

        return dataTransferService.dataTransfer(dataTransfer, chargePoint);
    }

    @Override
    public StartTransactionResponse startTransaction(StartTransactionRequest request, ChargePoint chargePoint) {
        return forwardService.startTransaction(request, chargePoint);
    }

    @Override
    public StopTransactionResponse stopTransaction(StopTransactionRequest request, ChargePoint chargePoint) {
        return forwardService.stopTransaction(request, chargePoint);
    }

    @Override
    public MeterValuesResponse meterValues(MeterValuesRequest request, ChargePoint chargePoint) {
        forwardService.meterValues(request, chargePoint);
        return new MeterValuesResponse();
    }

    // == Core - 중앙시스템에서 시작되는 메시지 == //



    @Override
    public String dataTransfer(String chargePointId, String vendorId, String messageId, String data) {

        DataTransferRequest dataTransferRequest = DataTransferRequest.builder()
                .vendorId(vendorId)
                .messageId(messageId)
                .data(data)
                .build();

        return sender.sendRequest(dataTransferRequest, chargePointId);
    }

    @Override
    public String getConfiguration(GetConfigurationDto request){
        GetConfiguration getConfiguration = GetConfiguration.fromRequest(request);
        GetConfigurationRequest getConfigurationRequest = GetConfigurationRequest.builder()
                .key(getConfiguration.getStringKey())
                .build();

        return sender.sendRequest(getConfigurationRequest, request.getChargePointId());
    }

    @Override
    public String changeAvailability(ChangeAvailabilityDto request) {
        ChangeAvailability changeAvailability = ChangeAvailability.fromRequest(request);

        ChangeAvailabilityRequest changeAvailabilityRequest = ChangeAvailabilityRequest.builder()
                                                    .connectorId(changeAvailability.getConnectorId())
                                                    .type(changeAvailability.getType())
                                                    .build();

        return sender.sendRequest(changeAvailabilityRequest, request.getChargePointId());
    }

    @Override
    public String changeConfiguration(ChangeConfigurationDto request) {
        String value = request.getValue();

        if(request.getKey().equals(AuthorizationKey)) {
            byte[] bytes = value.getBytes();
            String hex = DatatypeConverter.printHexBinary(bytes);
            request.setValue(value);
            value = hex;
        }
        keyValueService.updateConfiguration(request);
        ChangeConfigurationRequest changeConfigurationRequest = ChangeConfigurationRequest.builder()
                                                                            .key(request.getKey())
                                                                            .value(value)
                                                                            .build();

        return sender.sendRequest(changeConfigurationRequest, request.getChargePointId());
    }

    @Override
    public String clearCache(ClearCacheDto request){
        return sender.sendRequest(new ClearCacheRequest(), request.getChargePointId());
    }

    @Override
    public String remoteStartTransaction(RemoteStartTransactionDto request) {
        RemoteStartTransaction remoteStartTransaction = RemoteStartTransaction.fromRequest(request);

        ChargingProfileDto chargingProfileDto = null;

        if(request.getChargingProfileId() != null){
            ChargingProfile chargingProfile = smartChargingService.findById(request.getChargingProfileId());
            chargingProfileDto = ChargingProfileDto.of(chargingProfile, null);
        }

        RemoteStartTransactionRequest remoteStartTransactionRequest = RemoteStartTransactionRequest.builder()
                                    .idTag(remoteStartTransaction.getIdTag().getValue())
                                    .connectorId(remoteStartTransaction.getConnectorId())
                                    .chargingProfile(chargingProfileDto)
                                    .build();

        return sender.sendRequest(remoteStartTransactionRequest, request.getChargePointId());
    }

    @Override
    public String remoteStopTransaction(RemoteStopTransactionDto request){
        RemoteStopTransaction remoteStopTransaction = RemoteStopTransaction.fromRequest(request);
        RemoteStopTransactionRequest remoteStopTransactionRequest = RemoteStopTransactionRequest.builder()
                .transactionId(remoteStopTransaction.getTransactionId())
                .build();

        return sender.sendRequest(remoteStopTransactionRequest, request.getChargePointId());
    }

    @Override
    public String reset(ResetDto request) {
        Reset reset = Reset.fromRequest(request);
        ResetRequest resetRequest = ResetRequest.builder()
                .type(reset.getType())
                .build();

        return sender.sendRequest(resetRequest, request.getChargePointId());
    }

    @Override
    public String unlockConnector(UnlockConnectorDto request) {
        UnlockConnector unlockConnector = UnlockConnector.fromRequest(request);
        UnlockConnectorRequest unlockConnectorRequest = UnlockConnectorRequest.builder()
                                                        .connectorId(request.getConnectorId())
                                                        .build();

        return sender.sendRequest(unlockConnectorRequest, request.getChargePointId());
    }


    // == Reservation - 중앙시스템에서 시작하는 메시지 == //

    @Override
    public String reserveNow(ReserveNowDto request){
        ReserveNow reserveNow = ReserveNow.fromRequest(request);
        //TODO : Reserve 오면 기존에 예약이 있으면 취소하기 or 메시지 안 보내고 그냥 실패 응답 보내기
        ReserveNowRequest reserveNowRequest = reservationService.create(reserveNow, request.getChargePointId());
//        chargerStatusService.updateChargerStatus(ChargePointStatus.Reserved, request.getChargePointId());

        return sender.sendRequest(reserveNowRequest, request.getChargePointId());
    }

    @Override
    public String cancelReservation(CancelReservationDto request) {
        CancelReservation cancelReservation = CancelReservation.fromRequest(request);
        reservationService.cancel(cancelReservation);
        CancelReservationRequest cancelReservationRequest = CancelReservationRequest.builder()
                                                        .reservationId(cancelReservation.getReservationId())
                                                        .build();

        return sender.sendRequest(cancelReservationRequest, request.getChargePointId());
    }

    // == Remote Trigger - 중앙시스템에서 시작하는 메시지 == //

    @Override
    public String triggerMessage(TriggerMessageDto request) {
        TriggerMessage triggerMessage = TriggerMessage.fromRequest(request);
        TriggerMessageRequest triggerMessageRequest = TriggerMessageRequest.builder()
                .requestedMessage(triggerMessage.getRequestedMessage())
                .connectorId(triggerMessage.getConnectorId())
                .build();
        return sender.sendRequest(triggerMessageRequest, request.getChargePointId());
    }

    // == Local Auth List Management - 중앙시스템에서 시작하는 메시지 == //

    @Override
    public String getLocalListVersion(GetLocalListVersionDto request) {
        GetLocalListVersionRequest getLocalListVersionRequest = new GetLocalListVersionRequest();

        return sender.sendRequest(getLocalListVersionRequest, request.getChargePointId());
    }

    @Override
    public String sendLocalList(SendLocalListDto request) {
        SendLocalListRequest sendLocalListRequest = localListService.createRequest(request);
        return sender.sendRequest(sendLocalListRequest, request.getChargePointId());
    }


    // == Firmware Management - 충전기에서 시작하는 메시지 == //
    @Override
    public DiagnosticsStatusNotificationResponse diagnosticStatusNotification(
                    DiagnosticsStatusNotificationRequest request,
                    ChargePoint chargePoint) {

        chargerStatusService.updateDiagnosticStatus(request.getStatus(), chargePoint.getChargeId());

        return new DiagnosticsStatusNotificationResponse();
    }

    @Override
    public FirmwareStatusNotificationResponse firmwareStatusNotification(
                    FirmwareStatusNotificationRequest request,
                    ChargePoint chargePoint) {
//        chargerStatusService.updateFirmwareStatus(request.getStatus(), chargePoint.getChargeId());

        return new FirmwareStatusNotificationResponse();
    }

    // == Firmware Management - 중앙시스템에서 시작하는 메시지 == //
    @Override
    public String getDiagnostics(GetDiagnosticsDto request) {
        GetDiagnosticsRequest getDiagnosticsRequest =
                GetDiagnosticsRequest.builder()
                        .location(request.getLocation())
                        .retries(request.getRetries())
                        .retryInterval(request.getRetryInterval())
                        .startTime(request.getStartTime())
                        .stopTime(request.getStopTime())
                        .build();

        return sender.sendRequest(getDiagnosticsRequest, request.getChargePointId());
    }

    @Override
    public String updateFirmware(UpdateFirmwareDto request) {
        UpdateFirmwareRequest updateFirmwareRequest = UpdateFirmwareRequest.builder()
                        .location(request.getLocation())
                        .retrieveDate(request.getRetrieveDate())
                        .retries(request.getRetires())
                        .retryInterval(request.getRetryInterval())
                        .build();

        return sender.sendRequest(updateFirmwareRequest, request.getChargePointId());
    }


    // == Smart Charging - 중앙시스템에서 시작하는 메시지 == //
    @Override
    public String clearChargingProfile(ClearChargingProfileDto request) {
        ClearChargingProfileRequest clearChargingProfileRequest = ClearChargingProfileRequest.builder()
                .id(request.getId())
                .connectorId(request.getConnectorId())
                .chargingProfilePurpose(request.getChargingProfilePurpose())
                .stackLevel(request.getStackLevel())
                .build();

        return sender.sendRequest(clearChargingProfileRequest, request.getChargePointId());
    }

    @Override
    public String getCompositeSchedule(GetCompositeScheduleDto request) {
        GetCompositeScheduleRequest compositeScheduleRequest = GetCompositeScheduleRequest.builder()
                        .connectorId(request.getConnectorId())
                        .duration(request.getDuration())
                        .chargingRateUnit(request.getChargingRateUnit())
                        .build();

        return sender.sendRequest(compositeScheduleRequest, request.getChargePointId());
    }

    @Override
    public String setChargingProfile(SetChargingProfileDto request) {
        ChargingProfile chargingProfile = smartChargingService.findById(request.getChargingProfileId());

        ChargingProfileDto chargingProfileDto = ChargingProfileDto.of(chargingProfile, request.getTransactionId());

        SetChargingProfileRequest profileRequest = SetChargingProfileRequest.builder()
                                                .connectorId(request.getConnectorId())
                                                .csChargingProfiles(chargingProfileDto)
                                                .build();

        return sender.sendRequest(profileRequest, request.getChargePointId());
    }

    // == Security - 충전기에서 시작하는 메시지 == //
    @Override
    public LogStatusNotificationResponse logStatusNotification(LogStatusNotificationRequest request, ChargePoint chargePoint) {
        // TODO: 상태 볼 수 있는 기능 만들어야 됨
        return new LogStatusNotificationResponse();
    }

    @Override
    public SecurityEventNotificationResponse securityEventNotification(SecurityEventNotificationRequest request, ChargePoint chargePoint) {
        // TODO: 상태 볼수 있는 기능 만들어야 됨
        return new SecurityEventNotificationResponse();
    }

    @Override
    public SignedFirmwareStatusNotificationResponse signedFirmwareStatusNotification(SignedFirmwareStatusNotificationRequest request, ChargePoint chargePoint) {
        // TODO: 상태 볼수 있는 기능 만들어야 됨
        return new SignedFirmwareStatusNotificationResponse();
    }

    // == Security - 중앙시스템에서 시작하는 메시지 == //
    @Override
    public String certificateSigned(CertificateSignedDto request) {
        CertificateSignedRequest certificateSignedRequest = CertificateSignedRequest.builder()
                                                .certificateChain(request.getCertificateChain())
                                                .build();
        return sender.sendRequest(certificateSignedRequest, request.getChargePointId());
    }

    @Override
    public String getLog(GetLogDto request) {
        Long id = securityLogService.create(request);


        LogDto logDto = LogDto.builder()
                .remoteLocation(request.getRemoteLocation())
                .oldestTimestamp(request.getOldestTimestamp())
                .latestTimestamp(request.getLatestTimestamp())
                .build();
        GetLogRequest getLogRequest = GetLogRequest.builder()
                        .logType(request.getLogType())
                        .requestId(id)
                        .log(logDto)
                        .retries(request.getRetries())
                        .retryInterval(request.getRetryInterval())
                        .build();

        return sender.sendRequest(getLogRequest, request.getChargePointId());
    }

    @Override
    public String installCertificate(InstallCertificateDto request) {
        InstallCertificateRequest installCertificateRequest = new InstallCertificateRequest(
                request.getCertificateType(),
                request.getCertificate());

        return sender.sendRequest(installCertificateRequest, request.getChargePointId());
    }

    @Override
    public String getInstalledCertificateIds(GetInstalledCertificateIdsDto request) {
        GetInstalledCertificateIdsRequest getInstalledCertificateIdsRequest = new GetInstalledCertificateIdsRequest(
                request.getCertificateType());
        return sender.sendRequest(getInstalledCertificateIdsRequest, request.getChargePointId());
    }

    @Override
    public String deleteCertificate(DeleteCertificateDto request) {
        CertificateHashData hashData = new CertificateHashData(
                request.getHashAlgorithm(),
                request.getIssuerNameHash(),
                request.getIssuerKeyHash(),
                request.getSerialNumber()
        );
        DeleteCertificateRequest deleteCertificateRequest = new DeleteCertificateRequest(hashData);
        return sender.sendRequest(deleteCertificateRequest, request.getChargePointId());
    }

    @Override
    public String signedUpdateFirmware(SignedUpdateFirmwareDto request) {
        long requestId = idGenerator.incrementAndGet();
        byte[] signatureBytes = Base64.getEncoder().encode(request.getSignature().getBytes());

        SecureFirmware secureFirmware = new SecureFirmware(
                request.getLocation(),
                request.getRetrieveDateTime(),
                request.getInstallDateTime(),
                request.getSigningCertificate(),
                new String(signatureBytes)
        );

        SignedUpdateFirmwareRequest signedUpdateFirmwareRequest = SignedUpdateFirmwareRequest.builder()
                                                        .requestId(requestId)
                                                        .firmware(secureFirmware)
                                                        .retries(request.getRetries())
                                                        .retryInterval(request.getRetryInterval())
                                                        .build();

        return sender.sendRequest(signedUpdateFirmwareRequest, request.getChargePointId());
    }
}
