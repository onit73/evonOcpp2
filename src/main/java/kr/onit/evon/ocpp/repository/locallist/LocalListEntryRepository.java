package kr.onit.evon.ocpp.repository.locallist;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.locallist.LocalListEntry;
import kr.onit.evon.ocpp.repository.locallist.query.LocalListQueryRepository;

public interface LocalListEntryRepository extends JpaRepository<LocalListEntry, Long>, LocalListQueryRepository {
}
