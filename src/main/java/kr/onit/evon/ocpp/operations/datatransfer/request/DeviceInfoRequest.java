package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceInfoRequest {
    private String deviceName;
    private String mainVersion;
    private String version1;
    private String version2;
}
