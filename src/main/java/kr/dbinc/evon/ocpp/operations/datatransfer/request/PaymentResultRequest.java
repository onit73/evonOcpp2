package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentResultRequest {
    private int connectorId;
    private String timestamp;
    private String transactionCode;
    private String transactionMethod;
    private String cardNum;
    private String authAmount;
    private String tax;
    private String serviceFee;
    private String approvalNum;
    private String transactionDate;
    private String transactionTime;
    private String transactionNum;
    private String payId;
    private String marketNum;
    private String terminalNum;
    private String ccRejectMsg;
    private String vanRejectMsg;
    private String pgTransactionNum;
    private String publisherName;
    private String payMethod;
    private MembershipPointDataRequest membershipPointData;
}
