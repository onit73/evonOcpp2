package kr.onit.evon.ocpp.operations.getconfiguration;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import kr.onit.evon.ocpp.types.CiString;
import kr.onit.evon.ocpp.web.dto.GetConfigurationDto;

@Getter
public class GetConfiguration {

    private final List<CiString> key;

    private GetConfiguration(GetConfigurationDto request){
        this.key = request.getKey().stream()
                .map(key -> new CiString(key, CiString.Length.TYPE50))
                .collect(Collectors.toList());
    }

    public static GetConfiguration fromRequest(GetConfigurationDto request) {
        return new GetConfiguration(request);
    }

    public List<String> getStringKey(){
        return getKey().stream()
                .map(CiString::getValue)
                .collect(Collectors.toList());
    }
}
