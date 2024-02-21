package kr.onit.evon.ocpp.operations.datatransfer.request;

import kr.onit.evon.ocpp.web.dto.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PricePerTimeRequest {
    private int connectorId;
}
