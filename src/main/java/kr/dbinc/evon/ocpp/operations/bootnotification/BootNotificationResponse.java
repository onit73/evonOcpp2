package kr.dbinc.evon.ocpp.operations.bootnotification;

import lombok.*;

import java.time.ZonedDateTime;

import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.ocpp.types.enums.RegistrationStatus;
import kr.dbinc.evon.util.DateUtil;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BootNotificationResponse implements ResponseType {

    private ZonedDateTime currentTime;
    private Integer interval;
    private RegistrationStatus status;


}
