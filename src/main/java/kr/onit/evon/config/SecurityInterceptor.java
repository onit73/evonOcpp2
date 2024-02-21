package kr.onit.evon.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import kr.onit.evon.ocpp.repository.charger.ChargerStatusRepository;
import kr.onit.evon.ocpp.service.SecurityService;
import kr.onit.evon.util.ConditionHandler;
import kr.onit.evon.util.UriUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityInterceptor implements HandshakeInterceptor {

    private final SecurityService securityService;
    private final UriUtil util = UriUtil.INSTANCE;
    
    @Override
    public boolean beforeHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {

        HttpHeaders headers = request.getHeaders();

        String chargeBoxSerialNumber = util.extractChargePointId(request.getURI());
        String findLevel = securityService.getSecurityProfileLevel(chargeBoxSerialNumber);

        ConditionHandler<String> level = new ConditionHandler<>(findLevel);

        if(!StringUtils.hasText(findLevel) && level.notIn("0", "1", "2", "3")) {
            log.info("Charger is rejected URI={}, findLevel={}", request.getURI(), findLevel);
            return false;
        }

        List<String> protocol = headers.get("Sec-WebSocket-Protocol");
        if(protocol == null || protocol.size() <= 0 || !protocol.get(0).equals("ocpp1.6"))
            return false;

        log.info("Connect Try Charger URI={}, findLevel={}", request.getURI(), findLevel);

        if( level.in("0", "3") )
            return true;

        List<String> result = headers.get("authorization");

        if(result != null && result.size() > 0)
            return securityService.basicAuthentication(result.get(0), chargeBoxSerialNumber);
        else
            return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        
    }
}
