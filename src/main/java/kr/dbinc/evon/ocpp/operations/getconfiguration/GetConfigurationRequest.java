package kr.dbinc.evon.ocpp.operations.getconfiguration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import kr.dbinc.evon.ocpp.types.CiString;
import kr.dbinc.evon.ocpp.types.RequestType;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetConfigurationRequest implements RequestType {

    private final List<String> key;
    
}
