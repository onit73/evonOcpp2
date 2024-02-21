package kr.onit.evon.ocpp.operations.certificatesigned;

import kr.onit.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class CertificateSignedRequest implements RequestType {

    private final String certificateChain;

}
