package kr.dbinc.evon.ws.handler;

import lombok.NonNull;

//import org.hibernate.mapping.Collection;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;

import kr.dbinc.evon.config.WebSocketConfig;
import kr.dbinc.evon.ocpp.repository.charger.ChargerStatusRepository;
import kr.dbinc.evon.session.ChargePoint;
import kr.dbinc.evon.session.ChargePointStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.Collection;

public abstract class ConcurrentWebSocketHandler implements WebSocketHandler {

    private static final int sendTimeLimit = (int) TimeUnit.SECONDS.toMillis(10);
    private static final int bufferSizeLimit = 5 * WebSocketConfig.MAX_MSG_SIZE;

    private final Map<String, ConcurrentWebSocketSessionDecorator> sessions = new ConcurrentHashMap<>();
    
    private static ChargePointStore chargePointStore;
    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        /*
        Collection<ChargePoint> chargePoints = chargePointStore.getAllChargePoint();
        Boolean existSession = false;
        for (ChargePoint chargePoint : chargePoints) {
            if(chargePoint.getSession().getUri().equals(session.getUri())){
                
                existSession = true;
                
            }
        }

        //WS Session URI 존재시 후행 세션 종료처리
        if(existSession){
            session.close();
        }else{
         */    
            this.onOpen(internalGet(session));
        //}
        
    }

    @Override
    public void handleMessage(@NonNull WebSocketSession session,@NonNull WebSocketMessage<?> message) throws Exception {
        this.onMessage(internalGet(session), message);
    }

    @Override
    public void handleTransportError(@NonNull WebSocketSession session,@NonNull Throwable exception) throws Exception {
        this.onError(internalGet(session), exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,@NonNull CloseStatus closeStatus) throws Exception {
        this.onClose(sessions.remove(session.getId()), closeStatus);
        
    }

    private ConcurrentWebSocketSessionDecorator internalGet(WebSocketSession session) {
        return sessions.computeIfAbsent(session.getId(), s -> new ConcurrentWebSocketSessionDecorator(session, sendTimeLimit, bufferSizeLimit));
    }



    abstract void onMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception;
    abstract void onOpen(WebSocketSession session) throws Exception;
    abstract void onClose(WebSocketSession session, CloseStatus closeStatus) throws Exception;
    abstract void onError(WebSocketSession session, Throwable throwable) throws Exception;
}
