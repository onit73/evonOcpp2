package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SmsMessageRequest {

    private Integer transactionId;
    private String teleNum;
}
