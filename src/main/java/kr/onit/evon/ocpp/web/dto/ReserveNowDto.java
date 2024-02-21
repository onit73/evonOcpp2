package kr.onit.evon.ocpp.web.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReserveNowDto extends BaseDto{
    private Integer connectorId;
    private String expiryDate;
    private String idTag;
}
