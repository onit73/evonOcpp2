package kr.dbinc.evon.ocpp.web.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTransferDto extends BaseDto{

    private String vendorId;
    private String messageId;
    private JsonNode data;

}
