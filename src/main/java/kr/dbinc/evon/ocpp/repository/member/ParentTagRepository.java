package kr.dbinc.evon.ocpp.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.member.ParentTag;

public interface ParentTagRepository extends JpaRepository<ParentTag, Long> {
}
