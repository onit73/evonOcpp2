package kr.dbinc.evon.ocpp.operations.installcertificate;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.CertificateUse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InstallCertificateRequest implements RequestType {

    private final CertificateUse certificateType;
    private final String certificate;
}
