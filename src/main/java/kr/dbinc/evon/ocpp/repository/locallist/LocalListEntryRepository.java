package kr.dbinc.evon.ocpp.repository.locallist;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.locallist.LocalListEntry;
import kr.dbinc.evon.ocpp.repository.locallist.query.LocalListQueryRepository;

public interface LocalListEntryRepository extends JpaRepository<LocalListEntry, Long>, LocalListQueryRepository {
}
