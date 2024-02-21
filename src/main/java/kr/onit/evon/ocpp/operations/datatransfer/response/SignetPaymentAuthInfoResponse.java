package kr.onit.evon.ocpp.operations.datatransfer.response;


import kr.onit.evon.ocpp.types.CommonStatus;
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
