package kr.dbinc.evon.ocpp.web.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;

import kr.dbinc.evon.app.price.domain.VariablePrice;
import kr.dbinc.evon.app.price.service.VariablePriceService;
import kr.dbinc.evon.ocpp.component.ResultStore;
import kr.dbinc.evon.ocpp.exception.TimeoutException;
import kr.dbinc.evon.ocpp.operations.changeavailability.ChangeAvailabilityResponse;
import kr.dbinc.evon.ocpp.operations.changeconfiguration.ChangeConfigurationResponse;
import kr.dbinc.evon.ocpp.operations.clearcache.ClearCacheResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.AnnounceRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.PricePerTimeRequest;
import kr.dbinc.evon.ocpp.operations.getconfiguration.GetConfigurationResponse;
import kr.dbinc.evon.ocpp.operations.remotestarttransaction.RemoteStartTransactionResponse;
import kr.dbinc.evon.ocpp.operations.remotestoptransaction.RemoteStopTransactionResponse;
import kr.dbinc.evon.ocpp.operations.reset.ResetResponse;
import kr.dbinc.evon.ocpp.operations.unlockconnector.UnlockConnectorResponse;
import kr.dbinc.evon.ocpp.profile.Ocpp16Service;
import kr.dbinc.evon.ocpp.service.MsgLoggingService;
import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.ocpp.types.enums.DataTransferStatus;
import kr.dbinc.evon.ocpp.types.enums.RemoteStartStopStatus;
import kr.dbinc.evon.ocpp.types.enums.ResetStatus;
import kr.dbinc.evon.ocpp.web.dto.*;
import kr.dbinc.evon.ocpp.web.request.ChangePriceRequest;
import kr.dbinc.evon.ocpp.web.request.DisplayMessageRequest;
import kr.dbinc.evon.ocpp.web.request.SendCommandRequest;
import kr.dbinc.evon.session.ChargePoint;
import kr.dbinc.evon.session.ChargePointStore;
import kr.dbinc.evon.session.PricePerTable;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CoreController {

    private final Ocpp16Service ocpp16Service;
    private final ResultStore resultStore;

    private final ChargePointStore chargePointStore;
    private final MsgLoggingService loggingService;
    private final VariablePriceService variablePriceService;
    private final PricePerTable pricePerTable;

    @PostMapping("/close/{chargePointId}")
    public ResponseEntity<Void> close(@PathVariable("chargePointId") String chargePointId){
        ChargePoint chargePoint = chargePointStore.get(chargePointId);
        chargePointStore.remove(chargePointId, chargePoint.getSession());
        try {
            chargePoint.getSession().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/display-message")
    public DataTransferResponse displayMessage(@RequestBody DisplayMessageRequest request){
        String message = String.format("{\"message\":\"%s\"}", request.getMessage());

        String messageId = ocpp16Service.dataTransfer(
                request.getChargePointId(),
                request.getVendorId(),
                "DisplayMessage",
                message);

        try{
            return (DataTransferResponse)resultStore.getResult(messageId);
        }catch (TimeoutException e){
            return new DataTransferResponse(DataTransferStatus.Rejected, "");
        }
    }



    @PostMapping("/send-command")
    public DataTransferResponse sendCommand(@RequestBody SendCommandRequest request){
        String message = String.format("{\"command\":\"%s\"}", request.getCommand());

        String messageId = ocpp16Service.dataTransfer(
                request.getChargePointId(),
                request.getVendorId(),
                "SendCommand",
                message);

        try{
            return (DataTransferResponse)resultStore.getResult(messageId);
        }catch (TimeoutException e){
            return new DataTransferResponse(DataTransferStatus.Rejected, "");
        }
    }
/*
    @PostMapping("/change-price")
    public DataTransferResponse changePrice(@RequestBody ChangePriceRequest request){
        String message = String.format("{\"connectorId\":%d, \"transactionId\":%d, \"unitPrice\":%.1f",
                request.getConnectorId(),
                request.getTransactionId(),
                request.getUnitPrice());

        String messageId = ocpp16Service.dataTransfer(
                request.getChargePointId(),
                "EasyCharger",
                "ChangePrice",
                message);

        try{
            return (DataTransferResponse)resultStore.getResult(messageId);
        }catch (TimeoutException e){
            return new DataTransferResponse(DataTransferStatus.Rejected, "");
        }
    }
    */

    //단가 테이블 한번 초기화
    @PostMapping("/price-initialize")
    public void priceInitialize(){
        List<VariablePrice> variablePriceList = variablePriceService.findAll();
        pricePerTable.changePricePerHour(variablePriceList);
    }

    /*단가 테이블을 이용하여 price-per-time
    @PostMapping("/price-per-time")
    public DataTransferResponse pricePerTime(@RequestBody PricePerTimeRequest request){

        String message = String.format("{\"connectorId\":%d, " +
                        "\"member\": { \"t00\" :%d,\"t01\" :%d,\"t02\" :%d,\"t03\" :%d,\"t04\" :%d," +
                        "\"t05\" :%d,\"t06\" :%d,\"t07\" :%d,\"t08\" :%d,\"t09\" :%d,\"t10\" :%d,\"t11\" :%d,\"t12\" :%d,\"t13\" :%d," +
                        "\"t14\" :%d,\"t15\" :%d,\"t16\" :%d,\"t17\" :%d,\"t18\" :%d,\"t19\" :%d,\"t20\" :%d,\"t21\" :%d,\"t22\" :%d," +
                        "\"t23\" :%d }" +
                        " \"nonMember\": {\"t00\" :%d,\"t01\" :%d,\"t02\" :%d,\"t03\" :%d,\"t04\" :%d," +
                        "\"t05\" :%d,\"t06\" :%d,\"t07\" :%d,\"t08\" :%d,\"t09\" :%d,\"t10\" :%d,\"t11\" :%d,\"t12\" :%d,\"t13\" :%d," +
                        "\"t14\" :%d,\"t15\" :%d,\"t16\" :%d,\"t17\" :%d,\"t18\" :%d,\"t19\" :%d,\"t20\" :%d,\"t21\" :%d,\"t22\" :%d," +
                        "\"t23\" :%d }",
                request.getConnectorId(),
                request.getMember(),
                request.getNonMember());

        String messageId = ocpp16Service.dataTransfer(
                request.getChargePointId(),
                "EasyCharger",
                "PricePerTime",
                message);
        try{
            return (DataTransferResponse)resultStore.getResult(messageId);
        }catch (TimeoutException e){
            return new DataTransferResponse(DataTransferStatus.Rejected, "");
        }
    }*/
    /* Not Use 24/2/19
    @GetMapping("/changeAvailability")
    public String changeAvailability(ChangeAvailabilityDto request) {
        return ocpp16Service.changeAvailability(request);
    }

    @GetMapping("/result/changeAvailability")
    public ChangeAvailabilityResponse changeAvailability(@RequestParam("messageId") String messageId) {
        return (ChangeAvailabilityResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/changeConfiguration")
    public String changeConfiguration(ChangeConfigurationDto request) {
        return ocpp16Service.changeConfiguration(request);
    }

    @GetMapping("/result/changeConfiguration")
    public ChangeConfigurationResponse changeConfiguration(@RequestParam("messageId") String messageId) {
        return (ChangeConfigurationResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/getConfiguration")
    public String getConfiguration(GetConfigurationDto request) {
        return ocpp16Service.getConfiguration(request);
    }

    @GetMapping("/result/getConfiguration")
    public GetConfigurationResponse getConfiguration(@RequestParam("messageId") String messageId) {
        return (GetConfigurationResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/clearCache")
    public String clearCache(ClearCacheDto request) {
        return ocpp16Service.clearCache(request);
    }
    */

    @GetMapping("/result/clearCache")
    public ClearCacheResponse clearCache(@RequestParam("messageId") String messageId) {
        return (ClearCacheResponse) resultStore.getResult(messageId);
    }

    @PostMapping("/remote-start-transaction")
    public RemoteStartTransactionResponse remoteStartTransaction(@RequestBody RemoteStartTransactionDto request) {
        String messageId = ocpp16Service.remoteStartTransaction(request);

        try{
            //Map Clear and Return value
            RemoteStartTransactionResponse returnObj = (RemoteStartTransactionResponse)resultStore.getResult(messageId);
            
            loggingService.logging(request.getChargePointId(), request, returnObj.getStatus().toString(), "remote-start-transaction", messageId);
            return returnObj;
        }catch (TimeoutException e){
            return new RemoteStartTransactionResponse(RemoteStartStopStatus.Rejected);
        }
    }

    @PostMapping("/remote-stop-transaction")
    public RemoteStopTransactionResponse remoteStopTransaction(@RequestBody RemoteStopTransactionDto request){
        String messageId = ocpp16Service.remoteStopTransaction(request);

        try{
            
            //Map Clear and Return value
            RemoteStopTransactionResponse returnObj = (RemoteStopTransactionResponse)resultStore.getResult(messageId);
            
            loggingService.logging(request.getChargePointId(), request, returnObj.getStatus().toString(), "remote-stop-transaction", messageId);
            return returnObj;

        }catch (TimeoutException e){
            return new RemoteStopTransactionResponse(RemoteStartStopStatus.Rejected);
        }
    }

    @PostMapping("/reset")
    public ResetResponse reset(@RequestBody ResetDto request) {
        String messageId = ocpp16Service.reset(request);
        
        try{
            //Map Clear and Return value
            ResetResponse returnObj = (ResetResponse)resultStore.getResult(messageId);
            
            loggingService.logging(request.getChargePointId(), request, returnObj.getStatus().toString(), "reset", messageId);
            return returnObj;
        }catch(TimeoutException e){
            
            return new ResetResponse(ResetStatus.Rejected);
       }
    }

    @PostMapping("/announce")
    public DataTransferResponse announce(@RequestBody DataTransferDto request){
        //String message = String.format("{\"data\":\"%s\"}", request.getData());
        String message = request.getData().toString();

        String messageId = ocpp16Service.dataTransfer(
                request.getChargePointId(),
                request.getVendorId(),
                "announce",
                message);

        try{
            
            //Map Clear and Return value
            DataTransferResponse returnObj = (DataTransferResponse)resultStore.getResult(messageId);
            
            loggingService.logging(request.getChargePointId(), request, returnObj.getStatus().toString(), "announce", messageId);
            return returnObj;

        }catch (TimeoutException e){
            return new DataTransferResponse(DataTransferStatus.Rejected, "");
        }
    }

    /* 24/2/19
    @GetMapping("/result/reset")
    public ResetResponse reset(@RequestParam("messageId") String messageId) {
        return (ResetResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/unlockConnector")
    public String unlockConnector(UnlockConnectorDto request) {
        return ocpp16Service.unlockConnector(request);
    }

    @GetMapping("/result/unlockConnector")
    public UnlockConnectorResponse unlockConnector(@RequestParam("messageId") String messageId) {
        return (UnlockConnectorResponse) resultStore.getResult(messageId);
    }
    */
}
