package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccumulateMembershipPointsRequest {

    private int connectorId;
    private int payId;
    private String transactionResult;
    private String transactionType;
    private MembershipPointDataRequest membershipPointData;

}
