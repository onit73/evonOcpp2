package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReserveChargerRequest {

    private int connectorId;
    private String idTag;
    private String parentIdTag;
    private int reservationId;
    private int stopOngoingCharging; // 문서에 stopOngoinCharging이라고 되어 있음 에러나면 Ongoing -> Ongoin으로 수정해야 됨
    private String reservationStartTime;
    private String reservationEndTime;
    private String pincode;
    private String userDisplayInfo;
    private String expiryDate;


}
