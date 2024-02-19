package kr.dbinc.evon.ocpp.profile.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommonHeartbeatRequest {

    private String chargerMode;
    private String ezchstatus;
    private String sid;
    private String cid;
    private String chargerState;
}
