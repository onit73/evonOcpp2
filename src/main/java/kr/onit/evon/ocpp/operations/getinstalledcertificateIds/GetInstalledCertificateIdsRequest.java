package kr.onit.evon.ocpp.operations.getinstalledcertificateIds;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.CertificateUse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInstalledCertificateIdsRequest implements RequestType {

    private final CertificateUse certificateType;
}
