package kr.onit.evon.ocpp.operations.datatransfer.response;


import kr.onit.evon.ocpp.types.enums.AuthorizationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutoChargingAuthorizeResponse {
    private String idTag;
    private String parentIdTag;
    private AuthorizationStatus status;
}
