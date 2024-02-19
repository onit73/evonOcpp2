package kr.dbinc.evon.ocpp.operations.datatransfer.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StopTransactionSubInfoRequest {

    private int connectorId;
    private String idTag;
    private int sessionEnergy;
    private float sessionFee;
    private String currency;
    private String timestamp;
    private long transactionId;
    private String stopReason;
    private String memberCardNumber;
    private String evccid;

}
