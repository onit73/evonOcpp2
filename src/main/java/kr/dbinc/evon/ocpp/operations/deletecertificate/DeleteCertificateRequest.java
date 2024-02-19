package kr.dbinc.evon.ocpp.operations.deletecertificate;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.datatype.CertificateHashData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteCertificateRequest implements RequestType {

    private final CertificateHashData certificateHashData;

}
