package kr.dbinc.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignedUpdateFirmwareDto extends BaseDto{

    private Integer retries;
    private Integer retryInterval;
    private String location;
    private String retrieveDateTime;
    private String installDateTime;
    private String signingCertificate;
    private String signature;

}
