package kr.onit.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import kr.onit.evon.ocpp.types.IdTagInfo;
import kr.onit.evon.ocpp.types.IdToken;
import kr.onit.evon.ocpp.types.enums.AuthorizationStatus;
import kr.onit.evon.util.DateUtil;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorizeService {

    public IdTagInfo authorizeToken(IdToken token) {

        return IdTagInfo.builder()
                .expiryDate(DateUtil.INSTANCE.getNowUTCDate())
                .parentIdTag("PARENT_TAG")
                .status(AuthorizationStatus.Accepted)
                .build();
    }

}
