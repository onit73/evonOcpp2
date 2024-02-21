package kr.onit.evon.ocpp.web.dto;

import kr.onit.evon.ocpp.types.enums.CertificateUse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetInstalledCertificateIdsDto extends BaseDto {

    private CertificateUse certificateType;
}
