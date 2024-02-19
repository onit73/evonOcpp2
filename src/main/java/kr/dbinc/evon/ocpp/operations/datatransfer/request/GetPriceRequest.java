package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;
import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetPriceRequest implements DataTransferRequest{

   private Timestamp timestamp;
   private String idTag;
}
