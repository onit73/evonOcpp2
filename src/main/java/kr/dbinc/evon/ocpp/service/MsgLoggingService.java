package kr.dbinc.evon.ocpp.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.domain.logging.MsgLog;
import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.repository.charger.ChargerRepository;
import kr.dbinc.evon.ocpp.repository.message.MeLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MsgLoggingService {

    private final MeLogRepository meLogRepository;
    private final ChargerRepository chargerRepository;
    private final JsonObjectMapper jsonObjectMapper;

    @Transactional
    public void logging(String chargerId, Object request, String response, String message, String sessionIndex) {
        Calendar reqCal = Calendar.getInstance();
        String parsedRequest = parseObject(request);
        Timestamp logTimestamp = new Timestamp( reqCal.getTimeInMillis());
        long ts = logTimestamp.getTime();
        Charger charger = chargerRepository
                    .findByChargeId(chargerId)
                    .orElse(null);
        int cpId = charger.getCid();
        System.out.println("meLog message:"+message);
        if(message!=null){
            MsgLog meLog = buildLog(ts,logTimestamp, logTimestamp, message, chargerId, sessionIndex, logTimestamp, parsedRequest, response,cpId);
            meLogRepository.save(meLog);
        }
    }

    private MsgLog buildLog(Long ts, Timestamp logTimestamp, Timestamp recvTimestamp, String recvMessage, String chargerId
    , String recvSessionId, Timestamp sendTimestamp, Object request, String response, int sourceCpId ) {
        return MsgLog.builder()
                .ts(ts)
                .logTimestamp(logTimestamp)
                .logType("RECV")
                .recvTimestamp(recvTimestamp)
                .recvMessage(recvMessage)
                .recvMessageType("Request")
                .recvURL(chargerId)
                .recvSessionId(recvSessionId)
                .sendTimestamp(sendTimestamp)
                .recvPayload(request.toString())
                .sendMessage(recvMessage)
                .sendMessageType("Confirmation")
                .sendSessionId(recvSessionId)
                .sendPayload(response)
                .sourceCpId(sourceCpId)
                .build();
    }

    private String parseObject(Object object) {
        String result = "";
        try {
            result = jsonObjectMapper.getMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            result = e.getMessage();
            log.error(e.getMessage(), e);
        }
        return result;
    }

    private String getServerIp() {

        InetAddress local = null;
        try {
            local = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (local == null) {
            return "";
        } else {
            return local.getHostAddress();
        }
    }
}
