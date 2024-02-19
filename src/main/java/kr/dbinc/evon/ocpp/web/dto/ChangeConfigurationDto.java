package kr.dbinc.evon.ocpp.web.dto;

import kr.dbinc.evon.ocpp.types.enums.ConfigurationKey;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeConfigurationDto extends BaseDto{
    private ConfigurationKey key;
    private String value;

    public ChangeConfigurationDto(String chargePointId, ConfigurationKey key, String value) {
        super(chargePointId);
        this.key = key;
        this.value = value;
    }
}
