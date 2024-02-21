package kr.onit.evon.ocpp.repository.message;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.logging.MsgLog;

public interface MeLogRepository extends JpaRepository<MsgLog, Long> {
}
