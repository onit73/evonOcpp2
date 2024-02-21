package kr.onit.evon.ocpp.operations.datatransfer.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPricingProfileResponse {
    private int connectorId;
    private int profileVersion;
    private List<PricingProfileResponse> pricingProfile;
}
