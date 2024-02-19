package kr.dbinc.evon.ocpp.profile;

import kr.dbinc.evon.ocpp.operations.logstatusnotification.LogStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.logstatusnotification.LogStatusNotificationResponse;
import kr.dbinc.evon.ocpp.operations.securityeventnotification.SecurityEventNotificationRequest;
import kr.dbinc.evon.ocpp.operations.securityeventnotification.SecurityEventNotificationResponse;
import kr.dbinc.evon.ocpp.operations.signedfirmwarestatusnotification.SignedFirmwareStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.signedfirmwarestatusnotification.SignedFirmwareStatusNotificationResponse;
import kr.dbinc.evon.ocpp.web.dto.*;
import kr.dbinc.evon.session.ChargePoint;

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
