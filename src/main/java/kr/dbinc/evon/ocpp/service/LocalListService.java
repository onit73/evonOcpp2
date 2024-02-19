package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import kr.dbinc.evon.domain.locallist.LocalListEntry;
import kr.dbinc.evon.domain.locallist.LocalListVersion;
import kr.dbinc.evon.domain.member.Authorization;
import kr.dbinc.evon.ocpp.operations.sendlocallist.SendLocalListRequest;
import kr.dbinc.evon.ocpp.repository.locallist.LocalListEntryRepository;
import kr.dbinc.evon.ocpp.repository.locallist.LocalListVersionRepository;
import kr.dbinc.evon.ocpp.repository.locallist.dto.EntryDto;
import kr.dbinc.evon.ocpp.repository.member.AuthorizationRepository;
import kr.dbinc.evon.ocpp.rpc.exception.PropertyConstraintViolationException;
import kr.dbinc.evon.ocpp.types.IdTagInfo;
import kr.dbinc.evon.ocpp.types.dto.AuthorizationDataDto;
import kr.dbinc.evon.ocpp.types.enums.AuthorizationStatus;
import kr.dbinc.evon.ocpp.web.dto.SendLocalListDto;
import kr.dbinc.evon.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class LocalListService {

    private final AuthorizationRepository authorizationRepository;


    private final LocalListEntryRepository entryRepository;
    private final LocalListVersionRepository versionRepository;

    private Long getMaxLocalListSize(String chargePointId){
        // TODO: 충전기가 가질 수 있는 리스트의 최대 값 만큼 보내야 핣니다
        return 20L;
    }

    public SendLocalListRequest createRequest(SendLocalListDto request) {
        Long maxSize = getMaxLocalListSize(request.getChargePointId());


        LocalListVersion version = versionRepository.findByVersion(request.getListVersion()).orElseThrow(
                () -> new PropertyConstraintViolationException("존재하지 않는 리스트의 버전입니다. version = " + request.getListVersion())
        );

        List<EntryDto> entryDto = entryRepository.getAuthEntryDto(version, maxSize);

        List<AuthorizationDataDto> authorizationDataDtos = convertEntryToAuth(entryDto);

        return SendLocalListRequest.builder()
                .listVersion(version.getVersion())
                .updateType(request.getUpdateType())
                .localAuthorizationList(authorizationDataDtos)
                .build();

    }

    private List<AuthorizationDataDto> convertEntryToAuth(List<EntryDto> entryDto) {
        return entryDto.stream()
                .map(e -> {
                    IdTagInfo idTagInfoDto = IdTagInfo.builder()
                            .status(e.getStatus())
                            .expiryDate(DateUtil.INSTANCE.getNowUTCDate(e.getExpiryDate()))
                            .parentIdTag(e.getParentTag())
                            .build();
                    return AuthorizationDataDto.builder().idTag(e.getIdToken()).idTagInfo(idTagInfoDto).build();
                }).collect(Collectors.toList());
    }

    public void createList(){
        LocalDateTime before = LocalDateTime.now().minusMonths(1L);

        List<Authorization> authorizations = authorizationRepository
                .findByLastUsedDateAfterAndStatusEquals(before, AuthorizationStatus.Accepted);

        long count = entryRepository.count();
        LocalListVersion version = new LocalListVersion(count + 1);
        List<LocalListEntry> entries = authorizations.stream()
                .map(
                        (a) -> new LocalListEntry(version, a, authorizations.indexOf(a)+1)
                ).collect(Collectors.toList());

        versionRepository.save(version);
        entryRepository.saveAllAndFlush(entries);
    }

    //TODO: 최신 버전의 리스트와 이전 버전의 리스트들 사이의 차이에 대한 스냅샷을 만들어 놓으면 빠르게 계산할 수 있음

}
