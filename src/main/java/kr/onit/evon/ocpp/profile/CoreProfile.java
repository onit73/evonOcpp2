
package kr.onit.evon.ocpp.profile;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.onit.evon.ocpp.operations.authorize.AuthorizeRequest;
import kr.onit.evon.ocpp.operations.authorize.AuthorizeResponse;
import kr.onit.evon.ocpp.operations.bootnotification.BootNotificationRequest;
import kr.onit.evon.ocpp.operations.bootnotification.BootNotificationResponse;
import kr.onit.evon.ocpp.operations.datatransfer.DataTransferRequest;
import kr.onit.evon.ocpp.operations.datatransfer.DataTransferResponse;
import kr.onit.evon.ocpp.operations.heartbeat.HeartbeatRequest;
import kr.onit.evon.ocpp.operations.heartbeat.HeartbeatResponse;
import kr.onit.evon.ocpp.operations.metervalues.MeterValuesRequest;
import kr.onit.evon.ocpp.operations.metervalues.MeterValuesResponse;
import kr.onit.evon.ocpp.operations.starttransaction.StartTransactionRequest;
import kr.onit.evon.ocpp.operations.starttransaction.StartTransactionResponse;
import kr.onit.evon.ocpp.operations.statusnotification.StatusNotificationRequest;
import kr.onit.evon.ocpp.operations.statusnotification.StatusNotificationResponse;
import kr.onit.evon.ocpp.operations.stoptransaction.StopTransactionRequest;
import kr.onit.evon.ocpp.operations.stoptransaction.StopTransactionResponse;
import kr.onit.evon.ocpp.web.dto.*;
import kr.onit.evon.session.ChargePoint;

import java.text.ParseException;

public interface CoreProfile extends Profile{

    // Initiated by Charge Point
    AuthorizeResponse authorize(AuthorizeRequest request, ChargePoint chargePoint);

    BootNotificationResponse bootNotification(BootNotificationRequest request, ChargePoint chargePoint);

    StartTransactionResponse startTransaction(StartTransactionRequest request, ChargePoint chargePoint);

    StopTransactionResponse stopTransaction(StopTransactionRequest request, ChargePoint chargePoint) throws ParseException;

    DataTransferResponse dataTransfer(DataTransferRequest request, ChargePoint chargePoint) throws JsonProcessingException;

    HeartbeatResponse heartbeat(HeartbeatRequest request, ChargePoint chargePoint);

    MeterValuesResponse meterValues(MeterValuesRequest request, ChargePoint chargePoint);

    StatusNotificationResponse statusNotification(StatusNotificationRequest request, ChargePoint chargePoint);

    // Initiated by Central System

    String dataTransfer(String chargePointId, String vendorId, String messageId, String data);

    String changeAvailability(ChangeAvailabilityDto request);

    String changeConfiguration(ChangeConfigurationDto request);

    String getConfiguration(GetConfigurationDto request) ;

    String clearCache(ClearCacheDto request) ;

    String remoteStartTransaction(RemoteStartTransactionDto request);

    String remoteStopTransaction(RemoteStopTransactionDto request);

    String reset(ResetDto request);

    String unlockConnector(UnlockConnectorDto request);

}
