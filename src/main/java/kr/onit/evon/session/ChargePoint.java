package kr.onit.evon.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import kr.onit.evon.ocpp.operations.datatransfer.request.PaymentInfoRequest;
import kr.onit.evon.ocpp.operations.datatransfer.request.SignetPaymentAuthInfoRequest;
import kr.onit.evon.ocpp.types.enums.ChargePointStatus;
import kr.onit.evon.ocpp.types.enums.RegistrationStatus;
import kr.onit.evon.util.CommonUtil;
import kr.onit.evon.util.UriUtil;
import kr.onit.evon.util.me.MeChargerInfo;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class ChargePoint {

    private WebSocketSession session;
    private LocalDateTime lastReceivedMessage;

    public ChargePoint(WebSocketSession session){
        this.session = session;
    }

    public WebSocketSession getSession(){
        return session;
    }

    public void changeSession(WebSocketSession session) {
        WebSocketSession prev = this.session;
        this.session = session;

        try {
            prev.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getChargeId(){
        UriUtil uriUtil = UriUtil.INSTANCE;
        String chargePointId = uriUtil.extractChargePointId(session.getUri());
        return CommonUtil.removeLeadingZeroPrefix(chargePointId);
    }

    public String getChargePointId(){
        UriUtil uriUtil = UriUtil.INSTANCE;
        return uriUtil.extractChargePointId(session.getUri());
    }

    public MeChargerInfo getMeInfo(){
        String chargeId = getChargeId();
        return CommonUtil.convertToMeType(chargeId);
    }
    public void heartbeat(){
        this.lastReceivedMessage = LocalDateTime.now();
    }

    public boolean isTimeOut(){
        LocalDateTime before10Minutes = LocalDateTime.now().minusMinutes(10L);
        if(lastReceivedMessage!=null){
            return lastReceivedMessage.isBefore(before10Minutes);
        }
        return true;
    }
}
