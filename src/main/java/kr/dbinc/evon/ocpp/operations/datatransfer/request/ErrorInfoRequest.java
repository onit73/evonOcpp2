package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorInfoRequest {

    private int connectorId;
    private String idTag;
    private Long transactionId;
    private String sessionStartTime;
    private String timestamp;
    private String stopReason;
    private int evseErrorCode;
    private int evErrorCode;
    private int plcErrorCode;
    private int finishCode;
    private String evccid;

}
