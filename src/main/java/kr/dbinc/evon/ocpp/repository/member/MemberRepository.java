package kr.dbinc.evon.ocpp.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
