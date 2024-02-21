package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SetUserReservationRequest {
    private int connectorId;
    private int opMode;
    private String idTag;
    private String dateTime;
    private String phoneNumber;
}
