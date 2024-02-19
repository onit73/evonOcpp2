package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import kr.dbinc.evon.app.price.service.VariablePriceService;
import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.domain.common.CommonCode;
import kr.dbinc.evon.domain.roaming.RoamingPrice;
import kr.dbinc.evon.ocpp.repository.charger.ChargerRepository;
import kr.dbinc.evon.ocpp.repository.common.CommonCodeRepository;
import kr.dbinc.evon.ocpp.repository.roaming.RoamingPriceRepository;
import kr.dbinc.evon.util.CommonUtil;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService {

    private final ChargerRepository chargerRepository;
    private final RoamingPriceRepository roamingPriceRepository;
    private final CommonCodeRepository commonCodeRepository;
    private final VariablePriceService variablePriceService;

    public float getPrice(String chargePointId, String chargingType, String roamingCode) {

        if(chargingType.equals("1")) { // 회원
            return getChargerPrice(chargePointId);
        } else if(chargingType.equals("2")){ // 로밍회원
            return getRoamingPrice(roamingCode);
        }
        throw new IllegalStateException("회원의 타입이 잘못 되었습니다. 회원 타입=" + chargingType);
    }

    public float getChargerPrice(String chargePointId){
        String leadingZeroRemovedId = CommonUtil.removeLeadingZeroPrefix(chargePointId);
        Charger charger = chargerRepository.findByChargeId(leadingZeroRemovedId).orElseThrow(
                () -> new IllegalStateException("해당 충전기가 존재하지 않습니다. charger=" + leadingZeroRemovedId)
        );

        if(charger.getUnitPriceType() == 1) { // 계시별
            float price = variablePriceService.getPrice(LocalDateTime.now());
            return (float) (price * (charger.getPriceRate() / 100));
        }else{
            return charger.getFixedPrice() + charger.getOperationFee();
        }
    }

    public float getRoamingPrice(String roamingCode) {
        RoamingPrice roamingPrice = roamingPriceRepository.findById(roamingCode).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 Roaming Code입니다. code=" + roamingCode)
        );
        return (float) roamingPrice.getUnitPrice();
    }

    public float getNonMemberPrice(){
        CommonCode commonCode = commonCodeRepository.findById("NME-01").orElseThrow(
                () -> new IllegalStateException("비회원 충전 단가를 찾지 못했습니다.")
        );
        return Float.parseFloat(commonCode.getData());
    }
}

