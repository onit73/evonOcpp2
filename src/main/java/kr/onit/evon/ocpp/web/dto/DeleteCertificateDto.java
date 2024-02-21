package kr.onit.evon.ocpp.web.dto;

import kr.onit.evon.ocpp.types.enums.HashAlgorithm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCertificateDto extends BaseDto {

    private HashAlgorithm hashAlgorithm;
    private String issuerNameHash;
    private String issuerKeyHash;
    private String serialNumber;
}
