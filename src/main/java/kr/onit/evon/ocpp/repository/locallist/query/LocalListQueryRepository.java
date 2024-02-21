package kr.onit.evon.ocpp.repository.locallist.query;

import java.util.List;

import kr.onit.evon.domain.locallist.LocalListVersion;
import kr.onit.evon.ocpp.repository.locallist.dto.EntryDto;

public interface LocalListQueryRepository {

    List<EntryDto> getAuthEntryDto(LocalListVersion version, Long maxSize);
}
