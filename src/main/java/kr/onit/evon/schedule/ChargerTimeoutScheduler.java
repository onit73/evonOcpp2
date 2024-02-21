package kr.onit.evon.schedule;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.repository.charger.ChargerStatusRepository;
import kr.onit.evon.session.ChargePoint;
import kr.onit.evon.session.ChargePointStore;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChargerTimeoutScheduler {
    /* 스캐쥴 서버 제외 */
    private final ChargerStatusRepository chargerStatusRepository;
    private final ChargePointStore chargePointStore;

    @Scheduled(fixedRate = 60 * 1000) // 1분마다
    public void checkChargerStatus(){
        //chargerStatusRepository.updateTimeoutChargerStatus();
        Collection<ChargePoint> chargePoints = chargePointStore.getAllChargePoint();

        for (ChargePoint chargePoint : chargePoints) {
            if(chargePoint.isTimeOut()){
                //WS Session 종료 후 처리 커넥션상태 변경
                //chargerStatusRepository.insertCPConnectionStatus(chargePoint.getChargeId());
                chargerStatusRepository.updateCPConnectionStatus(chargePoint.getChargeId());
                chargePointStore.remove(chargePoint.getChargeId(), chargePoint.getSession());
                try {
                    chargePoint.getSession().close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
     
}
