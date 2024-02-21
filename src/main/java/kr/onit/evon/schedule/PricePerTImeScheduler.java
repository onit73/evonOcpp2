package kr.onit.evon.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.onit.evon.app.price.domain.VariablePrice;
import kr.onit.evon.app.price.service.VariablePriceService;
import kr.onit.evon.session.PricePerTable;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PricePerTImeScheduler {
    /*TODO
    private final VariablePriceService variablePriceService;
    private final PricePerTable pricePerTable;
    
    @Scheduled(cron = "0 0 * * * *") //정각 마다
   // @Scheduled(fixedRate = 60 * 1000) // 1분마다
    public void renewalPrice(){
        log.info("==renewalPrice call==");
        List<VariablePrice> variablePriceList = variablePriceService.findAll();
        pricePerTable.changePricePerHour(variablePriceList);
    }
     */
}
