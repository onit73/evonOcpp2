package kr.onit.evon.ocpp.operations.getinstalledcertificateIds;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.datatype.CertificateHashData;
import kr.onit.evon.ocpp.types.enums.GetInstalledCertificateStatus;
import lombok.Getter;

@Getter
public class GetInstalledCertificateIdsResponse implements ResponseType {
    private final GetInstalledCertificateStatus status;
    private final CertificateHashData certificateHashData;

    @JsonCreator
    public GetInstalledCertificateIdsResponse(
            @JsonProperty(value = "status", required = true) GetInstalledCertificateStatus status,
            @JsonProperty(value = "certificateHashData") CertificateHashData certificateHashData) {
        this.status = status;
        this.certificateHashData = certificateHashData;
    }
}
