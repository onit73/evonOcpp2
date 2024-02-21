package kr.onit.evon.ocpp.profile;

import kr.onit.evon.ocpp.operations.logstatusnotification.LogStatusNotificationRequest;
import kr.onit.evon.ocpp.operations.logstatusnotification.LogStatusNotificationResponse;
import kr.onit.evon.ocpp.operations.securityeventnotification.SecurityEventNotificationRequest;
import kr.onit.evon.ocpp.operations.securityeventnotification.SecurityEventNotificationResponse;
import kr.onit.evon.ocpp.operations.signedfirmwarestatusnotification.SignedFirmwareStatusNotificationRequest;
import kr.onit.evon.ocpp.operations.signedfirmwarestatusnotification.SignedFirmwareStatusNotificationResponse;
import kr.onit.evon.ocpp.web.dto.*;
import kr.onit.evon.session.ChargePoint;

public interface Security extends Profile{

    // Initiated by Charge Point
    LogStatusNotificationResponse logStatusNotification(LogStatusNotificationRequest request, ChargePoint chargePoint);
    SecurityEventNotificationResponse securityEventNotification(SecurityEventNotificationRequest request, ChargePoint chargePoint);
    SignedFirmwareStatusNotificationResponse signedFirmwareStatusNotification(SignedFirmwareStatusNotificationRequest request, ChargePoint chargePoint);

    // Initiated by Central System
    String certificateSigned(CertificateSignedDto request);
    String getLog(GetLogDto request);

    String installCertificate(InstallCertificateDto request);
    String getInstalledCertificateIds(GetInstalledCertificateIdsDto request);
    String deleteCertificate(DeleteCertificateDto request);

    String signedUpdateFirmware(SignedUpdateFirmwareDto request);
}
