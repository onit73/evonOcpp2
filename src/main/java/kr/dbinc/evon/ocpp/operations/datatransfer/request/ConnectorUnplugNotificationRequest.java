package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConnectorUnplugNotificationRequest {
    private int connectorId;
    private long transactionId;
    private String unpluggedAt;
}
