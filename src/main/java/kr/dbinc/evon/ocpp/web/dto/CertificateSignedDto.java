package kr.dbinc.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificateSignedDto extends BaseDto{
    private String certificateChain;
}