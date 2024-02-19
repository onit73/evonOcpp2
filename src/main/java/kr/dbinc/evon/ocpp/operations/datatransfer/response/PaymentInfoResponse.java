package kr.dbinc.evon.ocpp.operations.datatransfer.response;

import kr.dbinc.evon.ocpp.types.PaymentInfoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfoResponse {

    private PaymentInfoStatus status;
    private String payId;

}
