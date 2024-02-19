package kr.dbinc.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateFirmwareDto extends BaseDto{
    private String location;
    private Integer retires;
    private String retrieveDate;
    private Integer retryInterval;
}
