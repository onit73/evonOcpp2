package kr.dbinc.evon.ocpp.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.domain.charger.KeyValue;
import kr.dbinc.evon.ocpp.operations.getconfiguration.GetConfigurationResponse;
import kr.dbinc.evon.ocpp.operations.getconfiguration.KeyValueResponse;
import kr.dbinc.evon.ocpp.rpc.TaskContext;
import kr.dbinc.evon.ocpp.service.ChargerService;
import kr.dbinc.evon.ocpp.service.KeyValueService;
import kr.dbinc.evon.ocpp.types.enums.ConfigurationKey;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetConfigurationTask implements Task{

    private final KeyValueService keyValueService;
    private final ChargerService chargerService;

    @Override
    @Transactional
    public void execute(TaskContext context) {
        if(!(context.getResponse() instanceof GetConfigurationResponse))
            return;
        GetConfigurationResponse response = (GetConfigurationResponse)context.getResponse();
        List<KeyValueResponse> configurationKey = response.getConfigurationKey();
        if(configurationKey == null || configurationKey.size() <= 0)
            return;

        Charger charger = chargerService.getChargerByChargerId(context.getChargePointId());

        Map<ConfigurationKey, KeyValue> keyValueMap = keyValueService.getAllByChargeId(context.getChargePointId())
                .stream()
                .collect(Collectors.toMap(
                        KeyValue::getConfigKey,
                        k -> k));

        List<KeyValue> keyValues = configurationKey.stream().distinct()
                .filter(k -> !k.getKey().equals(ConfigurationKey.NotSupportedKey))
                .map(k -> KeyValue.builder()
                                    .charger(charger)
                                    .configKey(k.getKey())
                                    .configValue(k.getValue())
                                    .readOnly(k.getReadonly())
                                    .build())
                                    .collect(Collectors.toList());

        List<KeyValue> noPersists = new ArrayList<>();

        keyValues.forEach( k -> {
            if(keyValueMap.containsKey(k.getConfigKey())){
                keyValueMap.get(k.getConfigKey()).updateValue(k.getConfigValue());
            }else{
                noPersists.add(k);
            }
        });

        keyValueService.saveAll(noPersists);
    }
}
