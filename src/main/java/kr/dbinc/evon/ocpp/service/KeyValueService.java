package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.domain.charger.KeyValue;
import kr.dbinc.evon.ocpp.repository.charger.KeyValueRepository;
import kr.dbinc.evon.ocpp.web.dto.ChangeConfigurationDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class KeyValueService {

    private final KeyValueRepository keyValueRepository;
    private final ChargerService chargerService;

    public void updateConfiguration(ChangeConfigurationDto configuration){
        Optional<KeyValue> keyValueOptional = keyValueRepository.findByKeyAndChargeId(configuration.getKey(), configuration.getChargePointId());
        if(keyValueOptional.isPresent()){
            KeyValue keyValue = keyValueOptional.get();
            keyValue.updateValue(configuration.getValue());
        }else{
            Charger charger = chargerService.getChargerByChargerId(configuration.getChargePointId());
            KeyValue keyValue = KeyValue.builder()
                    .configKey(configuration.getKey())
                    .configValue(configuration.getValue())
                    .readOnly(false)
                    .charger(charger)
                    .build();

            keyValueRepository.save(keyValue);
        }
    }

    public void saveAll(List<KeyValue> keyValues){
        keyValueRepository.saveAllAndFlush(keyValues);
    }

    public Set<KeyValue> getAllByChargeId(String chargePointId) {
        return keyValueRepository.findAllByChargerId(chargePointId);
    }
}
