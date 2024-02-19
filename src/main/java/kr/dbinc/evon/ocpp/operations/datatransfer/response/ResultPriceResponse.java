package kr.dbinc.evon.ocpp.operations.datatransfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultPriceResponse {
    private int connectorId;
    private float resultPrice;
}
