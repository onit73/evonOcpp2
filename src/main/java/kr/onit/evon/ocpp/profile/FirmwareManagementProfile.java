package kr.onit.evon.ocpp.profile;

import kr.onit.evon.ocpp.operations.diagnosticsstatusnotification.DiagnosticsStatusNotificationRequest;
import kr.onit.evon.ocpp.operations.diagnosticsstatusnotification.DiagnosticsStatusNotificationResponse;
import kr.onit.evon.ocpp.operations.firmwarestatusnotification.FirmwareStatusNotificationRequest;
import kr.onit.evon.ocpp.operations.firmwarestatusnotification.FirmwareStatusNotificationResponse;
import kr.onit.evon.ocpp.web.dto.GetDiagnosticsDto;
import kr.onit.evon.ocpp.web.dto.UpdateFirmwareDto;
import kr.onit.evon.session.ChargePoint;

public interface FirmwareManagementProfile extends Profile {

    // 충전기에서 시작하는 메시지
    DiagnosticsStatusNotificationResponse diagnosticStatusNotification(DiagnosticsStatusNotificationRequest request, ChargePoint chargePoint);
    FirmwareStatusNotificationResponse firmwareStatusNotification(FirmwareStatusNotificationRequest request, ChargePoint chargePoint);

    // 서버에서 시작하는 메시지
    String getDiagnostics(GetDiagnosticsDto request);
    String updateFirmware(UpdateFirmwareDto request);
}
