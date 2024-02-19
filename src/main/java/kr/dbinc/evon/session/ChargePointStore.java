package kr.dbinc.evon.session;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import kr.dbinc.evon.util.CommonUtil;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class ChargePointStore {

    private final ConcurrentHashMap<String, ChargePoint> table = new ConcurrentHashMap<>();

    public void add(String chargePointId, WebSocketSession session){
        String removedZeroId = CommonUtil.removeLeadingZeroPrefix(chargePointId);

        if( isPresent(removedZeroId) ){
            ChargePoint chargePoint = table.get(removedZeroId);
            chargePoint.changeSession(session);
        }else{
            ChargePoint chargePoint = new ChargePoint(session);
            table.put(removedZeroId, chargePoint);
        }
    }

    public ChargePoint get(String chargePointId){
        return table.get(CommonUtil.removeLeadingZeroPrefix(chargePointId));
    }

    public void remove(String chargePointId, WebSocketSession session){
        String removedZeroId = CommonUtil.removeLeadingZeroPrefix(chargePointId);

        ChargePoint chargePoint = table.get(removedZeroId);
        if(chargePoint == null) return;

        String prev = chargePoint.getSession().getId();
        String cur = session.getId();
        if(prev.equals(cur))
            table.remove(removedZeroId);
        else
            log.info("세션 아이디가 일치하지 않습니다. prev={}, cur ={}", prev, cur);
    }

    public boolean isPresent(String chargePointId){
        String removedZeroId = CommonUtil.removeLeadingZeroPrefix(chargePointId);

        return table.containsKey(removedZeroId);
    }

    public Collection<ChargePoint> getAllChargePoint() {
        return table.values();
    }


}
