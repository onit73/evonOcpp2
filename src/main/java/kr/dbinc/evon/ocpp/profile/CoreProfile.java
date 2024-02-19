
package kr.dbinc.evon.ocpp.profile;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.dbinc.evon.ocpp.operations.authorize.AuthorizeRequest;
import kr.dbinc.evon.ocpp.operations.authorize.AuthorizeResponse;
import kr.dbinc.evon.ocpp.operations.bootnotification.BootNotificationRequest;
import kr.dbinc.evon.ocpp.operations.bootnotification.BootNotificationResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferResponse;
import kr.dbinc.evon.ocpp.operations.heartbeat.HeartbeatRequest;
import kr.dbinc.evon.ocpp.operations.heartbeat.HeartbeatResponse;
import kr.dbinc.evon.ocpp.operations.metervalues.MeterValuesRequest;
import kr.dbinc.evon.ocpp.operations.metervalues.MeterValuesResponse;
import kr.dbinc.evon.ocpp.operations.starttransaction.StartTransactionRequest;
import kr.dbinc.evon.ocpp.operations.starttransaction.StartTransactionResponse;
import kr.dbinc.evon.ocpp.operations.statusnotification.StatusNotificationRequest;
import kr.dbinc.evon.ocpp.operations.statusnotification.StatusNotificationResponse;
import kr.dbinc.evon.ocpp.operations.stoptransaction.StopTransactionRequest;
import kr.dbinc.evon.ocpp.operations.stoptransaction.StopTransactionResponse;
import kr.dbinc.evon.ocpp.web.dto.*;
import kr.dbinc.evon.session.ChargePoint;

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
