package kr.onit.evon.ocpp.operations.datatransfer.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import kr.onit.evon.ocpp.operations.datatransfer.PriceType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PricingProfileResponse {

    private PriceType priceType;
    private String currency;
    private List<PricingScheduleResponse> schedule;

}
