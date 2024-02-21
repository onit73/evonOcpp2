package kr.onit.evon.ocpp.operations.changeconfiguration;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.enums.ConfigurationKey;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChangeConfigurationRequest implements RequestType {

    private final ConfigurationKey key;
    private final String value;

}
