package kr.dbinc.evon.ocpp.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.dbinc.evon.ocpp.component.Sender;
import kr.dbinc.evon.ocpp.operations.authorize.AuthorizeRequest;
import kr.dbinc.evon.ocpp.operations.bootnotification.BootNotificationRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferRequest;
import kr.dbinc.evon.ocpp.operations.diagnosticsstatusnotification.DiagnosticsStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.firmwarestatusnotification.FirmwareStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.heartbeat.HeartbeatRequest;
import kr.dbinc.evon.ocpp.operations.logstatusnotification.LogStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.metervalues.MeterValuesRequest;
import kr.dbinc.evon.ocpp.operations.securityeventnotification.SecurityEventNotificationRequest;
import kr.dbinc.evon.ocpp.operations.signedfirmwarestatusnotification.SignedFirmwareStatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.starttransaction.StartTransactionRequest;
import kr.dbinc.evon.ocpp.operations.statusnotification.StatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.stoptransaction.StopTransactionRequest;
import kr.dbinc.evon.ocpp.profile.Ocpp16ServiceImpl;
import kr.dbinc.evon.ocpp.rpc.exception.NotSupportedException;
import kr.dbinc.evon.ocpp.rpc.exception.SecurityErrorException;
import kr.dbinc.evon.ocpp.rpc.message.Call;
import kr.dbinc.evon.ocpp.rpc.message.CallError;
import kr.dbinc.evon.ocpp.rpc.message.CallResult;
import kr.dbinc.evon.ocpp.rpc.message.Message;
import kr.dbinc.evon.ocpp.service.ChargerStatusService;
import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.session.ChargePoint;
import kr.dbinc.evon.session.ChargePointStore;
import kr.dbinc.evon.util.UriUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.text.ParseException;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageHandlerImpl implements MessageHandler{

    private final Ocpp16ServiceImpl ocpp16Service;
    private final ResultHandler resultHandler;

    private final ChargePointStore chargePointStore;
    private final Sender sender;

    private final UriUtil uriUtil = UriUtil.INSTANCE;

    @Override
    public void handleMessage(Message message, WebSocketSession session) {
        ChargePoint chargePoint = chargePointStore.get(uriUtil.extractChargePointId(session.getUri()));

        if(message instanceof Call){
            Call call = (Call) message;

            ResponseType res = dispatch(call, chargePoint);
            Message result = new CallResult(call.getUniqueId(), res);

            sender.sendResponse(result, session);

        }else if(message instanceof CallResult) {
            CallResult callResult = (CallResult) message;
            resultHandler.handleResult(callResult);
        }else if(message instanceof CallError){
            // TODO: Call Error 처리
        }
    }

    private ResponseType dispatch(Call call ,ChargePoint chargePoint) {
        RequestType request = call.getPayload();
        chargePoint.heartbeat();

        if(request instanceof AuthorizeRequest){
            return ocpp16Service.authorize((AuthorizeRequest) request, chargePoint);
        }
        else if(request instanceof BootNotificationRequest){
            return ocpp16Service.bootNotification((BootNotificationRequest) request, chargePoint);
        }
        else if(request instanceof StartTransactionRequest){
            return ocpp16Service.startTransaction((StartTransactionRequest) request, chargePoint);
        }
        else if(request instanceof StopTransactionRequest){
            return ocpp16Service.stopTransaction((StopTransactionRequest) request, chargePoint);
        }
        else if(request instanceof DataTransferRequest){
            return ocpp16Service.dataTransfer((DataTransferRequest) request, chargePoint);
        }
        else if(request instanceof HeartbeatRequest){
            return ocpp16Service.heartbeat((HeartbeatRequest) request, chargePoint);
        }
        else if(request instanceof MeterValuesRequest){
            return ocpp16Service.meterValues((MeterValuesRequest) request, chargePoint);
        }
        else if(request instanceof StatusNotificationRequest){
            return ocpp16Service.statusNotification((StatusNotificationRequest) request, chargePoint);
        }
        else if(request instanceof FirmwareStatusNotificationRequest){
            return ocpp16Service.firmwareStatusNotification((FirmwareStatusNotificationRequest) request, chargePoint);
        }
        else if(request instanceof DiagnosticsStatusNotificationRequest){
            return ocpp16Service.diagnosticStatusNotification((DiagnosticsStatusNotificationRequest) request, chargePoint);
        }
        else if(request instanceof LogStatusNotificationRequest){
            return ocpp16Service.logStatusNotification((LogStatusNotificationRequest) request, chargePoint);
        }
        else if(request instanceof SecurityEventNotificationRequest){
            return ocpp16Service.securityEventNotification((SecurityEventNotificationRequest) request, chargePoint);
        }
        else if(request instanceof SignedFirmwareStatusNotificationRequest){
            return ocpp16Service.signedFirmwareStatusNotification((SignedFirmwareStatusNotificationRequest) request, chargePoint);
        }
        else {
            throw new NotSupportedException("지원되지 않는 Action입니다. Action = " + request.getClass().getSimpleName());
        }
    }
}
