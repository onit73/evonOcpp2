package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChargerSettingInfoRequest {
    private int chargerAuthDevice;
    private String authType;
    private int language;
    private String paymentLimitSelection;
    private int systemLimitTime;
    private int systemLimitSOC;
    private int systemLimitEnergy;
    private int systemLimitVolt;
    private int systemLimitAmpere;
}
