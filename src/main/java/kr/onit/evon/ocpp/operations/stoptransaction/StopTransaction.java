package kr.onit.evon.ocpp.operations.stoptransaction;

import lombok.Getter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import kr.onit.evon.ocpp.types.IdToken;
import kr.onit.evon.ocpp.types.MeterValueVO;
import kr.onit.evon.ocpp.types.enums.Reason;
import kr.onit.evon.util.DateUtil;

@Getter
public class StopTransaction {
    private final IdToken idTag;
    private final Integer meterStop;
    private final ZonedDateTime timestamp;
    private final Long transactionId;
    private final Reason reason;
    private final List<MeterValueVO> transactionData;

    private StopTransaction(StopTransactionRequest request){
        this.idTag = new IdToken(request.getIdTag());
        meterStop = request.getMeterStop();
        timestamp = request.getTimestamp();
        reason = request.getReason();
        if(request.getTransactionData() == null) {
            transactionData = new ArrayList<>();
        }else {
            transactionData = MeterValueVO.fromRequests(request.getTransactionData());
        }
        this.transactionId = request.getTransactionId();
    }

    public static StopTransaction fromRequest(StopTransactionRequest request){
        return new StopTransaction(request);
    }
}
