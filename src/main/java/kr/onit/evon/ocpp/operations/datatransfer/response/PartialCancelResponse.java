package kr.onit.evon.ocpp.operations.datatransfer.response;

import kr.onit.evon.ocpp.types.CommonStatus;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PartialCancelResponse {

    private CommonStatus status;

}
