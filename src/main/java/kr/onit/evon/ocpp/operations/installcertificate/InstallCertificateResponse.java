package kr.onit.evon.ocpp.operations.installcertificate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.CertificateStatus;
import lombok.Getter;

@Getter
public class InstallCertificateResponse implements ResponseType {
    private final CertificateStatus status;

    @JsonCreator
    public InstallCertificateResponse(
            @JsonProperty(value = "status", required = true) CertificateStatus status) {
        this.status = status;
    }
}
