package kr.onit.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import kr.onit.evon.domain.security.SecurityLog;
import kr.onit.evon.ocpp.repository.security.SecurityLogRepository;
import kr.onit.evon.ocpp.web.dto.GetLogDto;
import kr.onit.evon.util.DateUtil;

@Service
@RequiredArgsConstructor
public class SecurityLogService {

    private final SecurityLogRepository securityLogRepository;

    public Long create(GetLogDto request){
        DateUtil dateUtil = DateUtil.INSTANCE;
        SecurityLog securityLog = new SecurityLog(
                request.getLogType(),
                request.getRemoteLocation(),
                dateUtil.stringToDate(request.getOldestTimestamp()),
                dateUtil.stringToDate(request.getLatestTimestamp())
        );

        securityLogRepository.save(securityLog);

        return securityLog.getId();
    }
}
