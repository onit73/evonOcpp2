package kr.dbinc.evon.ocpp.web.request;

import kr.dbinc.evon.ocpp.web.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePriceRequest extends BaseDto {

    private Integer connectorId;
    private Long transactionId;
    private Float unitPrice;

}
