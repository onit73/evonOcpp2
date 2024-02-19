package kr.dbinc.evon.ocpp.operations.datatransfer.response;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetIdTagProfileResponse {

    private ChargingSessionProfileResponse freeChargingProfile;
    private ChargingSessionProfileResponse affiliationChargingProfile;
    private LimitChargingProfileResponse limitChargingProfile;
    private String affiliationCode;
    private String affiliationName;
    private int wholeChargedEnergy;
    private int wholeChargedPrice;
    private float unitPrice;
    private int discountedRate;
    private int deposit;
    private List<AdditionalAuthorizeMethod> additionalAuthorizeMethodList;
    private String status;
    private String reason;
}
