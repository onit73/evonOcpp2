package kr.onit.evon.ocpp.web.dto;

import kr.onit.evon.ocpp.types.enums.Log;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLogDto extends BaseDto{
    private Log logType;
    private Integer retries;
    private Integer retryInterval;

    String remoteLocation;
    String oldestTimestamp;
    String latestTimestamp;
}
