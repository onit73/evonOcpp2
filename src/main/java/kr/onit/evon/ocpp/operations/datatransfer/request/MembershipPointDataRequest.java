package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MembershipPointDataRequest {
    private String pointType;
    private String transactionMethod;
    private String cardNum;
    private String clientId;
    private String approvalNum;
    private String approvalDate;
    private String accumTarget;
    private int availScore;
    private int occurScore;
    private int totalAccumScore;
    private int afterUseScore;
    private String responseCode;
    private String referText1;
    private String referText2;
    private String referText3;
    private String referText4;
}
