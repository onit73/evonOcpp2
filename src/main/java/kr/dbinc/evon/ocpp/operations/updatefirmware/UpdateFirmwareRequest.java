package kr.dbinc.evon.ocpp.operations.updatefirmware;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateFirmwareRequest implements RequestType {

    private final String location;
    private final Integer retries;
    private final String retrieveDate;
    private final Integer retryInterval;

}
