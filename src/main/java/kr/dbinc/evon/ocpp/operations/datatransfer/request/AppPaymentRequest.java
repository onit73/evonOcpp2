package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppPaymentRequest {

    private int payAmount;
}
