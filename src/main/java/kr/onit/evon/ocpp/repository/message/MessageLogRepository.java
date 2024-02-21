package kr.onit.evon.ocpp.repository.message;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.logging.MessageLog;

public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
