package kr.onit.evon.ocpp.repository.member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.member.Authorization;
import kr.onit.evon.ocpp.types.enums.AuthorizationStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    @EntityGraph(attributePaths = {"member", "parentTag"})
    Optional<Authorization> findByIdToken(String idToken);

    List<Authorization> findByLastUsedDateAfterAndStatusEquals(LocalDateTime date, AuthorizationStatus status);
}
