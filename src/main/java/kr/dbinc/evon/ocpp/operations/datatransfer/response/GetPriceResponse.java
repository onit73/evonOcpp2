package kr.dbinc.evon.ocpp.operations.datatransfer.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPriceResponse {

   private Timestamp timestamp;
   private String idTag;
   private ArrayList unitPrice;

}
