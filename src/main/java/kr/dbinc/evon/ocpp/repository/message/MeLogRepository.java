package kr.dbinc.evon.ocpp.repository.message;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.logging.MsgLog;

public interface MeLogRepository extends JpaRepository<MsgLog, Long> {
}
