package kr.dbinc.evon.ocpp.types.datatype;

import kr.dbinc.evon.ocpp.types.enums.HashAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CertificateHashData {

    private HashAlgorithm hashAlgorithm;
    private String issuerNameHash;
    private String issuerKeyHash;
    private String serialNumber;
}
