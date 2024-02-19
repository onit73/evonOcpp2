package kr.dbinc.evon.ocpp.web.dto;

import kr.dbinc.evon.ocpp.types.enums.CertificateUse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetInstalledCertificateIdsDto extends BaseDto {

    private CertificateUse certificateType;
}
