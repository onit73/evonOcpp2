package kr.onit.evon.ocpp.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.common.CommonCode;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {
}
