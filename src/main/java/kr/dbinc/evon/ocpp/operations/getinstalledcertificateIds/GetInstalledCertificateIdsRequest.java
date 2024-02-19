package kr.dbinc.evon.ocpp.operations.getinstalledcertificateIds;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.CertificateUse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInstalledCertificateIdsRequest implements RequestType {

    private final CertificateUse certificateType;
}
