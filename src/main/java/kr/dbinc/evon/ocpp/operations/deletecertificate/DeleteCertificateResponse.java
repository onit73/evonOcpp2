package kr.dbinc.evon.ocpp.operations.deletecertificate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.ocpp.types.enums.DeleteCertificateStatus;
import lombok.Getter;

@Getter
public class DeleteCertificateResponse implements ResponseType {
    private final DeleteCertificateStatus status;

    @JsonCreator
    public DeleteCertificateResponse(
            @JsonProperty(value = "status", required = true) DeleteCertificateStatus status) {
        this.status = status;
    }
}
