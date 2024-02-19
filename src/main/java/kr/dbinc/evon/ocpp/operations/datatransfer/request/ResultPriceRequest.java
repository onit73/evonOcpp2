package kr.dbinc.evon.ocpp.operations.datatransfer.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultPriceRequest implements DataTransferRequest{

    private int connectorId;
    private long transactionId;
    private float resultPrice;
}
