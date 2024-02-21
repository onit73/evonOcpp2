package kr.onit.evon.ocpp.operations.signedupdatefirmware;

import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.datatype.SecureFirmware;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignedUpdateFirmwareRequest implements RequestType {

    private final Integer retries;
    private final Integer retryInterval;
    private final Long requestId;
    private final SecureFirmware firmware;

}
