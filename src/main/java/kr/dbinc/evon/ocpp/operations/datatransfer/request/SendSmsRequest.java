package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SendSmsRequest {
    private String phoneNumber;
    private int connectorId;
    private int messageKind; // 1: 종료, 2: 에러, 3: 영수증
    private String timestamp;
    private int chargedTime;
    private int sessionEnergy;
    private int sessionFee;
    private int startSoc;
    private int finishSoc;
    private String idTag;
    private int transType;
    private int transactionId;
    private int estimatedPayAmt;
}
