package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentTransactionInfoRequest {

    private String evccid;
    private int connectorId;
    private int transactionId;
    private int currentChargingPrice;
    private int elapsed;
    private float unitPrice;
}
