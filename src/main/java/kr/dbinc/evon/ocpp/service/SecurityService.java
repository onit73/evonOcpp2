package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import kr.dbinc.evon.ocpp.repository.security.SecurityQueryRepository;

import static java.util.Base64.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SecurityService {

    private final SecurityQueryRepository securityQueryRepository;

    public boolean basicAuthentication(String authorization, String chargePointId){
        if( !authorization.startsWith("Basic "))
            return false;

        String substring = authorization.substring(6);

        byte[] decode = getDecoder().decode(substring);
        String[] auth = new String(decode).split(":");
        String username = chargePointId;
        String authCpId = auth[0];
        String password = auth[1];
        log.info("username={}, password={}, chargePointId={}", username, password, chargePointId);

        String findPassword = "";
        if(authCpId.equals(username)){
            findPassword = securityQueryRepository.getPassword(authCpId); 
        }else{
            findPassword = "NotAuthorize";
        }
        log.info("requestPassword={}, findPassword={}", password, findPassword);
        return password.equals(findPassword);
    }

    public String getSecurityProfileLevel(String chargePointId){
        return securityQueryRepository.getSecurityProfileLevel(chargePointId); 
    }
}
