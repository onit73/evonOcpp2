package kr.onit.evon.ocpp.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
