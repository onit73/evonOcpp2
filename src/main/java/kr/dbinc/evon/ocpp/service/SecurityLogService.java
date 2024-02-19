package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import kr.dbinc.evon.domain.security.SecurityLog;
import kr.dbinc.evon.ocpp.repository.security.SecurityLogRepository;
import kr.dbinc.evon.ocpp.web.dto.GetLogDto;
import kr.dbinc.evon.util.DateUtil;

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
