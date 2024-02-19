package kr.dbinc.evon.ocpp.operations.certificatesigned;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class CertificateSignedRequest implements RequestType {

    private final String certificateChain;

}
