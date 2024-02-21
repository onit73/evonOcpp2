package kr.onit.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.logging.MessageLog;
import kr.onit.evon.ocpp.repository.charger.ChargerRepository;
import kr.onit.evon.ocpp.repository.message.MessageLogRepository;
import kr.onit.evon.util.CommonUtil;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageLogService {

    private final MessageLogRepository messageLogRepository;
    private final ChargerRepository chargerRepository;

    @Transactional
    public void loggingMessage(String message, String chargerId){
        log.info("Charger={}, Message={}", chargerId, message);
        if(message.equals("Heartbeat")){
            String id = CommonUtil.removeLeadingZeroPrefix(chargerId);
            
            Charger charger = chargerRepository
                    .findByChargeId(id)
                    .orElse(null);
            
            MessageLog record = MessageLog.builder()
                    .charger(charger)
                    .sendDate(LocalDateTime.now())
                    .sourceCpId(charger.getCid())
                    .message(message)
                    .build();

            //log.info("Charger={}, Message={}", chargerId, message);
            
            messageLogRepository.saveAndFlush(record);
        }
    }
}
