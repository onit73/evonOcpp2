package kr.dbinc.evon.ocpp.operations.datatransfer.response;

import kr.dbinc.evon.ocpp.types.CommonStatus;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PartialCancelResponse {

    private CommonStatus status;

}
