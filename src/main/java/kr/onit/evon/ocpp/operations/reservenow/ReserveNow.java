package kr.onit.evon.ocpp.operations.reservenow;

import lombok.Getter;

import java.time.LocalDateTime;

import kr.onit.evon.ocpp.types.IdToken;
import kr.onit.evon.ocpp.web.dto.ReserveNowDto;
import kr.onit.evon.util.DateUtil;

@Getter
public class ReserveNow {

    private final Integer connectorId;
    private final LocalDateTime expiryDate;
    private final IdToken idTag;

    private ReserveNow(ReserveNowDto request){
        DateUtil dateUtil = DateUtil.INSTANCE;
        this.connectorId = request.getConnectorId();
        this.expiryDate = dateUtil.stringToDate(request.getExpiryDate());
        this.idTag = new IdToken(request.getIdTag());
    }

    public static ReserveNow fromRequest(ReserveNowDto request) {
        return new ReserveNow(request);
    }
}
