package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.ocpp.repository.charger.ChargerRepository;
import kr.dbinc.evon.util.CommonUtil;

@Service
@RequiredArgsConstructor
public class ChargerService {

    private final ChargerRepository chargerRepository;

    public Charger getChargerByChargerId(String chargePointId){
        String id = CommonUtil.removeLeadingZeroPrefix(chargePointId);
        return chargerRepository.findByChargeId(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 ChargePointI")
        );
    }
}
