package kr.onit.evon.ocpp.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.security.SecurityLog;

public interface SecurityLogRepository extends JpaRepository<SecurityLog, Long> {
}
