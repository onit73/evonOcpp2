package kr.onit.evon.ocpp.operations.datatransfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PricingScheduleResponse {

    private int startPeriod;
    private float unitPrice;
}
