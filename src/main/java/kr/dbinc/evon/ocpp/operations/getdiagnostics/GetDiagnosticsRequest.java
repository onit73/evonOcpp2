package kr.dbinc.evon.ocpp.operations.getdiagnostics;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetDiagnosticsRequest implements RequestType {

    private final String location;
    private final Integer retries;
    private final Integer retryInterval;
    private final String startTime;
    private final String stopTime;


}
