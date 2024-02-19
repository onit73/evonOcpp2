package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignetPartialCancelRequest {

    private int connectorId;
    private String payId;
    private String pgTransactionNum;
    private int deposit;
    private float sessionFee;
    private LocalDateTime timestamp;
    private String transactionId;
}
