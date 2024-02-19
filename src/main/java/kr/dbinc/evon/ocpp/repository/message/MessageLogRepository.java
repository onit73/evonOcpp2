package kr.dbinc.evon.ocpp.repository.message;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.logging.MessageLog;

public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
