package kr.dbinc.evon.ocpp.repository.locallist.query;

import java.util.List;

import kr.dbinc.evon.domain.locallist.LocalListVersion;
import kr.dbinc.evon.ocpp.repository.locallist.dto.EntryDto;

public interface LocalListQueryRepository {

    List<EntryDto> getAuthEntryDto(LocalListVersion version, Long maxSize);
}
