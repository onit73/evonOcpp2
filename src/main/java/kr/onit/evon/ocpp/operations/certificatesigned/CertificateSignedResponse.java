package kr.onit.evon.ocpp.operations.certificatesigned;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.CertificateSignedStatus;
import lombok.Getter;

@Getter
public class CertificateSignedResponse implements ResponseType {

    private final CertificateSignedStatus status;

    @JsonCreator
    public CertificateSignedResponse(
            @JsonProperty(value = "status", required = true) CertificateSignedStatus status) {
        this.status = status;
    }
}
