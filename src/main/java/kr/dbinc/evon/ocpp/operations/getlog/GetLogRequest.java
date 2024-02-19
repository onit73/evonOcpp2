package kr.dbinc.evon.ocpp.operations.getlog;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.enums.Log;
import kr.dbinc.evon.ocpp.web.dto.LogDto;
import lombok.*;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetLogRequest implements RequestType {

    private final Log logType;
    private final Long requestId;
    private final Integer retries;
    private final Integer retryInterval;
    private final LogDto log;

}
