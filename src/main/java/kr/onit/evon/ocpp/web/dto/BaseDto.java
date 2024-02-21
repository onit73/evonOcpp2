package kr.onit.evon.ocpp.web.dto;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
    private String chargePointId;

    /*
    public String getChargerId(){
        long chargerId = Long.parseLong(chargePointId);
        return String.format("%010d", chargerId);
    }
    */
}
