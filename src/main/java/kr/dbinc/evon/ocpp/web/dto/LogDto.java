package kr.dbinc.evon.ocpp.web.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LogDto {

    String remoteLocation;
    String oldestTimestamp;
    String latestTimestamp;

}
