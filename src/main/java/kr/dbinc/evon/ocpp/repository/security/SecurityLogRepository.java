package kr.dbinc.evon.ocpp.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.security.SecurityLog;

public interface SecurityLogRepository extends JpaRepository<SecurityLog, Long> {
}
