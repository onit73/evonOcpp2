package kr.dbinc.evon.ocpp.profile.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommonStopTransactionRequest {
    private String chargingStartTime;
    private String useWh;
    private String chargingTime;
    private String chargingWh;
    private String chargerMode;
    private String chargingMoney;
    private String sid;
    private String cid;
    private String chargerState;


}
