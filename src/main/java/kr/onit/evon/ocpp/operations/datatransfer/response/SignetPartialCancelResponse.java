package kr.onit.evon.ocpp.operations.datatransfer.response;


import kr.onit.evon.ocpp.types.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignetPartialCancelResponse {

    private CommonStatus status;
    private String reason;
}
