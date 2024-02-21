package kr.onit.evon.ocpp.operations.getconfiguration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import kr.onit.evon.ocpp.types.CiString;
import kr.onit.evon.ocpp.types.RequestType;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetConfigurationRequest implements RequestType {

    private final List<String> key;
    
}
