package kr.dbinc.evon.ocpp.operations.statusnotification;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import kr.dbinc.evon.ocpp.types.CiString;
import kr.dbinc.evon.ocpp.types.enums.ChargePointErrorCode;
import kr.dbinc.evon.ocpp.types.enums.ChargePointStatus;
import kr.dbinc.evon.util.DateUtil;


@Getter
public class StatusNotification {
    private final int connectorId;
    private final ChargePointErrorCode errorCode;
    private final String info;
    private final ChargePointStatus status;
    private final ZonedDateTime timestamp;
    private final String vendorId;
    private final String vendorErrorCode;

    public StatusNotification(StatusNotificationRequest request) {
        DateUtil dateUtil = DateUtil.INSTANCE;
        this.connectorId = request.getConnectorId();
        this.errorCode = request.getErrorCode();
        this.info = request.getInfo();
        this.status = request.getStatus();

        if(request.getTimestamp() == null){
            this.timestamp = ZonedDateTime.now();
        }else{
            this.timestamp = request.getTimestamp();
        }
        this.vendorId = request.getVendorId();
        this.vendorErrorCode = request.getVendorErrorCode();
    }

    public static StatusNotification fromRequest(StatusNotificationRequest request){
        return new StatusNotification(request);
    }
}
