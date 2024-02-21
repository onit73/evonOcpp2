package kr.onit.evon.ocpp.operations.getlog;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.Log;
import kr.onit.evon.ocpp.web.dto.LogDto;
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
