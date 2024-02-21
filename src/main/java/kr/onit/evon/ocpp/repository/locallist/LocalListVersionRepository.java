package kr.onit.evon.ocpp.repository.locallist;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.locallist.LocalListVersion;

import java.util.Optional;

public interface LocalListVersionRepository extends JpaRepository<LocalListVersion, Long> {

    Optional<LocalListVersion> findByVersion(Long version);

}
