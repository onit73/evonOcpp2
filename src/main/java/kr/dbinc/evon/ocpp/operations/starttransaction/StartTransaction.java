package kr.dbinc.evon.ocpp.operations.starttransaction;

import lombok.Getter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import kr.dbinc.evon.ocpp.types.IdToken;
import kr.dbinc.evon.util.DateUtil;

@Getter
public class StartTransaction {

    private final Integer connectorId;
    private final String idTag;
    private final Integer meterStart;
    private final Long reservationId;
    private final ZonedDateTime timestamp;

    private StartTransaction(StartTransactionRequest request){
        DateUtil dateUtil = DateUtil.INSTANCE;
        this.connectorId = request.getConnectorId();
        this.idTag = request.getIdTag();
        this.meterStart = request.getMeterStart();
        this.reservationId = request.getReservationId();
        this.timestamp = request.getTimestamp();
    }
    public static StartTransaction fromRequest(StartTransactionRequest request) {
        return new StartTransaction(request);
    }


}
