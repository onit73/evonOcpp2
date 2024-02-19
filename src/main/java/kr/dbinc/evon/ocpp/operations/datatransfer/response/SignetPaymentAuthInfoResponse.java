package kr.dbinc.evon.ocpp.operations.datatransfer.response;


import kr.dbinc.evon.ocpp.types.CommonStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class SignetPaymentAuthInfoResponse {

    private CommonStatus status;
    private String reason;
}
