package kr.onit.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetChargingProfileDto extends BaseDto{

    private Integer connectorId;
    private Long chargingProfileId;
    private Long transactionId;
}
