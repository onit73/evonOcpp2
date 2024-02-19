package kr.dbinc.evon.ocpp.web.dto;


import kr.dbinc.evon.ocpp.types.enums.ChargingProfilePurposeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClearChargingProfileDto extends BaseDto{

    private Long id;
    private Integer connectorId;
    private ChargingProfilePurposeType chargingProfilePurpose;
    private Integer stackLevel;
}
