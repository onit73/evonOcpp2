package kr.onit.evon.ocpp.types.datatype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SecureFirmware {

    private final String location;
    private final String retrieveDateTime;
    private final String installDateTime;
    private final String signingCertificate;
    private final String signature;

}
