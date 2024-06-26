package kr.onit.evon.ocpp.operations.changeconfiguration;

import kr.onit.evon.ocpp.types.CiString;
import kr.onit.evon.ocpp.types.enums.ConfigurationKey;
import kr.onit.evon.ocpp.web.dto.ChangeConfigurationDto;
import lombok.Getter;

@Getter
public class ChangeConfiguration {

    private final ConfigurationKey key;
    private final CiString value;

    private ChangeConfiguration(ChangeConfigurationDto request){
        this.key = request.getKey();
        this.value = new CiString(request.getValue(), CiString.Length.TYPE500);
    }

    public static ChangeConfiguration fromRequest(ChangeConfigurationDto request) {
        return new ChangeConfiguration(request);
    }
}
