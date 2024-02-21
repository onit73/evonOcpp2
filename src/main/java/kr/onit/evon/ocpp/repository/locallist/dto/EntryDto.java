package kr.onit.evon.ocpp.repository.locallist.dto;

import lombok.Data;

import java.time.LocalDateTime;

import kr.onit.evon.ocpp.types.enums.AuthorizationStatus;

@Data
public class EntryDto {

    private String idToken;
    private LocalDateTime expiryDate;
    private String parentTag;
    private AuthorizationStatus status;

    public EntryDto() {
    }

    public EntryDto(String idToken, LocalDateTime expiryDate, String parentTag, AuthorizationStatus status) {
        this.idToken = idToken;
        this.expiryDate = expiryDate;
        this.parentTag = parentTag;
        this.status = status;
    }
}
