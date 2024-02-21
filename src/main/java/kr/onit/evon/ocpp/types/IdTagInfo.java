package kr.onit.evon.ocpp.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import kr.onit.evon.ocpp.types.enums.AuthorizationStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IdTagInfo {
    private ZonedDateTime expiryDate;
    private String parentIdTag;
    private AuthorizationStatus status;
}
