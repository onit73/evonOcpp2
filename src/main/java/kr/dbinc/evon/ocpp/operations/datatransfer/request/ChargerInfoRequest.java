package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChargerInfoRequest {

    private MainboardStatusRequest mainboardStatus;
    private PowerbankStatusRequest powerbankStatus;
    private PaymentSettingInfoRequest paymentSettingInfo;
    private ChargerSettingInfoRequest chargerSettingInfo;
    private DeviceInfoRequest deviceInfo;
    private String timestamp;
}
