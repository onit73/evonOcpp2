package kr.dbinc.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDiagnosticsDto extends BaseDto{
    private String location;
    private Integer retries;
    private Integer retryInterval;
    private String startTime;
    private String stopTime;
}
