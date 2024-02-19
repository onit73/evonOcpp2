package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MainboardStatusRequest {
    private int mainboardNumber;
    private String mainboardVersion;
    private String mainboardProtocolVersion;
}
