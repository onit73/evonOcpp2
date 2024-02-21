package kr.onit.evon.ocpp.operations.datatransfer.request;

import java.sql.Timestamp;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PartialCancelRequest {

   private String chargeBoxSerialNumber;
   private int connectorId;
   private Timestamp timestamp;
   private String pgTransactionNum;
   private String payId;
   private int transactionId;
   private Timestamp startTimeStamp;
   private Timestamp stopTimeStamp;
   private int deposit;
   private int payResult;

}
