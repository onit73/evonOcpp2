package kr.dbinc.evon.schedule;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.dbinc.evon.ocpp.service.LocalListService;

import javax.annotation.PostConstruct;

//@Component
@RequiredArgsConstructor
@Profile(value = "local")
public class LocalAuthScheduler {
    /*TODO
    private final LocalListService localListService;

    @PostConstruct
    public void init(){
        localListService.createList();
    }

    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public void updateList(){
        localListService.createList();
    }
     */
}
