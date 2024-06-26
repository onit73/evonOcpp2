package kr.onit.evon.ocpp.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.operations.changeconfiguration.ChangeConfigurationRequest;
import kr.onit.evon.ocpp.operations.changeconfiguration.ChangeConfigurationResponse;
import kr.onit.evon.ocpp.rpc.TaskContext;
import kr.onit.evon.ocpp.service.KeyValueService;
import kr.onit.evon.ocpp.web.dto.ChangeConfigurationDto;

import static kr.onit.evon.ocpp.types.enums.ConfigurationKey.*;
import static kr.onit.evon.ocpp.types.enums.ConfigurationStatus.*;

import javax.xml.bind.DatatypeConverter;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChangeConfigurationTask implements Task{

    private final KeyValueService keyValueService;
    private final ThreadLocal<String> chargePointIdStore;

    @Override
    public void execute(TaskContext context) {
        ChangeConfigurationRequest request = (ChangeConfigurationRequest)context.getRequest();
        ChangeConfigurationResponse response = (ChangeConfigurationResponse)context.getResponse();

        if(response.getStatus().equals(Accepted)){
            String value = request.getValue();
            if(request.getKey().equals(AuthorizationKey)){
                //TODO: 64Base -> Hex로 수정해야 됨
                value = new String(DatatypeConverter.parseHexBinary(value));
                log.info("value={}", value);
            }
            ChangeConfigurationDto dto = new ChangeConfigurationDto(
                    chargePointIdStore.get(),
                    request.getKey(),
                    value);
            keyValueService.updateConfiguration(dto);
        }
    }
}
