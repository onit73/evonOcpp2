package kr.dbinc.evon.ocpp.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.common.CommonCode;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {
}
