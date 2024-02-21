package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AutoChargingAuthorizeRequest {
    private String evccid;
    private int connectorId;
}
