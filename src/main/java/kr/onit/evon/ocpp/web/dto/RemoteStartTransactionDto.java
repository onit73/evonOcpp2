package kr.onit.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RemoteStartTransactionDto extends BaseDto{
    private String idTag;
    private Integer connectorId;
    private Long chargingProfileId;
}
