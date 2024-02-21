package kr.onit.evon.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.repository.charger.ChargerStatusRepository;
import kr.onit.evon.session.ChargePoint;
import kr.onit.evon.session.ChargePointStore;

import java.io.IOException;
import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClearTimeOutSessionScheduler {
    
    private final ChargePointStore chargePointStore;
    private final ChargerStatusRepository chargerStatusRepository;
    @Scheduled(fixedRate = 1000 * 60)
    public void checkCompleteSession(){
        log.info("ClearTimeOutSessionScheduler start#######");
        Collection<ChargePoint> chargePoints = chargePointStore.getAllChargePoint();

        for (ChargePoint chargePoint : chargePoints) {
            log.info("ChargePoint ChargeId:"+chargePoint.getChargeId()+", Session:"+chargePoint.getSession());
            if(chargePoint.isTimeOut()){
                //WS Session 종료 후 처리 커넥션상태 변경
                //chargerStatusRepository.insertCPConnectionStatus(chargePoint.getChargeId());
                log.info("ClearTimeOutSession ChargeId:"+chargePoint.getChargeId()+", Session:"+chargePoint.getSession());
                chargerStatusRepository.updateCPConnectionStatus(chargePoint.getChargeId());
                chargePointStore.remove(chargePoint.getChargeId(), chargePoint.getSession());
                try {
                    chargePoint.getSession().close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        log.info("ClearTimeOutSessionScheduler end#######");
    }
    
}
