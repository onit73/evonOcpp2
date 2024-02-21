package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PowerbankStatusRequest {
    private int pbNumber;
    private String pbVersion;
    private int pbMeterValue;
    private String pbModuleStatus;
}
