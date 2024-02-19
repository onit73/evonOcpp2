package kr.dbinc.evon.ocpp.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.dbinc.evon.ocpp.operations.authorize.AuthorizeRequest;
import kr.dbinc.evon.ocpp.operations.authorize.AuthorizeResponse;
import kr.dbinc.evon.ocpp.operations.bootnotification.BootNotificationRequest;
import kr.dbinc.evon.ocpp.operations.bootnotification.BootNotificationResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.*;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.*;
import kr.dbinc.evon.ocpp.operations.heartbeat.HeartbeatRequest;
import kr.dbinc.evon.ocpp.operations.heartbeat.HeartbeatResponse;
import kr.dbinc.evon.ocpp.operations.metervalues.MeterValuesRequest;
import kr.dbinc.evon.ocpp.operations.starttransaction.StartTransactionRequest;
import kr.dbinc.evon.ocpp.operations.starttransaction.StartTransactionResponse;
import kr.dbinc.evon.ocpp.operations.statusnotification.StatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.stoptransaction.StopTransactionRequest;
import kr.dbinc.evon.ocpp.operations.stoptransaction.StopTransactionResponse;
import kr.dbinc.evon.ocpp.rpc.exception.InternalErrorException;
import kr.dbinc.evon.ocpp.types.IdTagInfo;
import kr.dbinc.evon.ocpp.types.enums.AuthorizationStatus;
import kr.dbinc.evon.session.ChargePoint;
import kr.dbinc.evon.util.DateUtil;
import kr.dbinc.evon.util.EcosApiServer;
import kr.dbinc.evon.util.me.MeChargerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import java.time.ZonedDateTime;
import java.util.Calendar;


@Slf4j
@Service
@RequiredArgsConstructor
public class MessageForwardService {

    private final EcosApiServer client;
    private final ObjectMapper objectMapper;

    private final MsgLoggingService loggingService;
    
    private String getChargerId(ChargePoint chargePoint) {
        MeChargerInfo info = chargePoint.getMeInfo();
        //return info.getSid() + info.getCid();
        return info.getCid();
    }


    public BootNotificationResponse bootNotification(BootNotificationRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        log.info("chargerId ={}", request.getChargePointVendor());
        WebSocketSession ws = chargePoint.getSession();
        
        String result = client.postCallApiServer("/v2/BootNotification/"+chargerId, request);
        log.info("BootNotification result={}", result);
        loggingService.logging(chargerId, request, result, "BootNotification", ws.getId());
        try {
            return objectMapper.readValue(result, BootNotificationResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }
    }

    public HeartbeatResponse heartbeat(HeartbeatRequest request, ChargePoint chargePoint){

        final HeartbeatResponse confirmation = new HeartbeatResponse(); 
        return confirmation;
        
    }

    public void statusNotification(StatusNotificationRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        WebSocketSession ws = chargePoint.getSession();
        
        String result = client.postCallApiServer("/v2/StatusNotification/"+chargerId, request);
        
        loggingService.logging(chargerId, request, "{}", "StatusNotification", ws.getId());
        
    }

    public AuthorizeResponse authorize(AuthorizeRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        WebSocketSession ws = chargePoint.getSession();

        String result = client.postCallApiServer("/v2/Authorize/"+chargerId, request);
        log.trace("a1 result={}", result);
        loggingService.logging(chargerId, request, result, "Authorize", ws.getId());

        try {
            return objectMapper.readValue(result, AuthorizeResponse.class);

        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return AuthorizeResponse.builder()
                    .idTagInfo(new IdTagInfo(DateUtil.INSTANCE.getNowUTCDate(), "P_TAG", AuthorizationStatus.Invalid))
                    .build();
        }
    }

    public StartTransactionResponse startTransaction(StartTransactionRequest request, ChargePoint chargePoint){
        String chargerId = getChargerId(chargePoint);
        WebSocketSession ws = chargePoint.getSession();
        String result = client.postCallApiServer("/v2/StartTransaction/"+chargerId, request);
        loggingService.logging(chargerId, request, result, "StartTransaction", ws.getId());

        try {
            return objectMapper.readValue(result, StartTransactionResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }

    }

    public void meterValues(MeterValuesRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        WebSocketSession ws = chargePoint.getSession();
        String result = client.postCallApiServer("/v2/MeterValues/"+chargerId, request);
        loggingService.logging(chargerId, request, result, "MeterValues", ws.getId());
    }

    public StopTransactionResponse stopTransaction(StopTransactionRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        String result = client.postCallApiServer("/v2/StopTransaction/"+chargerId, request);
        WebSocketSession ws = chargePoint.getSession();

        loggingService.logging(chargerId, request, result, "StopTransaction", ws.getId());

        try {
            if(result.equals("ERROR")){
                IdTagInfo idTagInfo = new IdTagInfo(ZonedDateTime.now(), "P_TAG", AuthorizationStatus.Invalid);
                return StopTransactionResponse.builder()
                        .idTagInfo(idTagInfo)
                        .build();
            }

            return objectMapper.readValue(result, StopTransactionResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }
    }

    public GetPriceResponse getPrice(GetPriceRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        String result = client.postCallApiServer("/v2/getPrice/"+chargerId, request);
        WebSocketSession ws = chargePoint.getSession();
        //loggingService.logging(chargerId, request, result, "GetPrice");
        loggingService.logging(chargerId, request, result, "GetPrice", ws.getId());
        try {
            return objectMapper.readValue(result, GetPriceResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }
    }

    //resultPrice
    public ResultPriceResponse resultPrice(ResultPriceRequest request , ChargePoint chargePoint){
        String chargerId = getChargerId(chargePoint);
        String result = client.postCallApiServer("/v2/resultPrice/"+chargerId,request);
        log.trace("charger={}, resultPrice={}, result={}", chargePoint.getChargeId(), request, result);
        //loggingService.logging(chargerId,request,result,"ResultPrice");
        WebSocketSession ws = chargePoint.getSession();
        loggingService.logging(chargerId, request, result, "ResultPrice", ws.getId());
        try{
            return objectMapper.readValue(result,ResultPriceResponse.class);
        }catch (JsonProcessingException e){
            throw new InternalErrorException(e.getMessage(),e);
        }
    }

    public PaymentInfoResponse payInfo(PaymentInfoRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        String result = client.postCallApiServer("/v2/payInfo/"+chargerId, request);
        WebSocketSession ws = chargePoint.getSession();
        log.trace("charger={}, PayInfo={}, result={}", chargePoint.getChargeId(), request, result);
        
        loggingService.logging(chargerId, request, result, "PayInfo", ws.getId());
        try {
            return objectMapper.readValue(result, PaymentInfoResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }
    }

    public PartialCancelResponse partialCancel(PartialCancelRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        String result = client.postCallApiServer("/v2/partialCancel/"+chargerId, request);
        WebSocketSession ws = chargePoint.getSession();
        loggingService.logging(chargerId, request, result, "partialCancel", ws.getId());
        try {
            return objectMapper.readValue(result, PartialCancelResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }
    }


    public SmsMessageResponse smsMessage(SmsMessageRequest request, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        String result = client.postCallApiServer("/v2/smsMessage/"+chargerId, request);
        WebSocketSession ws = chargePoint.getSession();
        log.trace("charger={}, smsMessage={}, result={}", chargePoint.getChargeId(), request, result);
        
        loggingService.logging(chargerId, request, result, "smsMessage", ws.getId());
        try {
            return objectMapper.readValue(result, SmsMessageResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }
    }

    public GetIdTagPriceResponse getIdTagProfile(String idTag, ChargePoint chargePoint) {
        String chargerId = getChargerId(chargePoint);
        GetIdTagPriceRequest request = new GetIdTagPriceRequest(idTag);
        String result = client.postCallApiServer("/v2/get-id-tag-profile", request);
        //loggingService.logging(chargerId, request, result, "getIdTagProfile");
        try {
            return objectMapper.readValue(result, GetIdTagPriceResponse.class);
        } catch (JsonProcessingException e) {
            throw new InternalErrorException(e.getMessage(), e);
        }
    }
}
