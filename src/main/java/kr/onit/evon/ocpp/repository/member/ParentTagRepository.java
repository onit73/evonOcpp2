package kr.onit.evon.ocpp.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.member.ParentTag;

public interface ParentTagRepository extends JpaRepository<ParentTag, Long> {
}
