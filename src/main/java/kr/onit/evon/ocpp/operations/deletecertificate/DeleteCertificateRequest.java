package kr.onit.evon.ocpp.operations.deletecertificate;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.datatype.CertificateHashData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteCertificateRequest implements RequestType {

    private final CertificateHashData certificateHashData;

}
