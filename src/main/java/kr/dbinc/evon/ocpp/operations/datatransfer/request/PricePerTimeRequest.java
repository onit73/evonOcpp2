package kr.dbinc.evon.ocpp.operations.datatransfer.request;

import kr.dbinc.evon.ocpp.web.dto.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PricePerTimeRequest {
    private int connectorId;
}
