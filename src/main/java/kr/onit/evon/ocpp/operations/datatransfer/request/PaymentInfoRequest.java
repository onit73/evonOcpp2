package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentInfoRequest {

   private String chargeBoxSerialNumber;
   private String sessionId;
   private int connectorId;
   private Timestamp timestamp;
   private String pgTransactionNum;
   private String payId;
   private String approvalNum;
   private String transactionDate;
   private String transactionTime;
   private String authAmount;
   private String cardNum;
   
}
