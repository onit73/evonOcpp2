package kr.onit.evon.ocpp.operations.bootnotification;

import lombok.*;

import java.time.ZonedDateTime;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.ocpp.types.enums.RegistrationStatus;
import kr.onit.evon.util.DateUtil;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BootNotificationResponse implements ResponseType {

    private ZonedDateTime currentTime;
    private Integer interval;
    private RegistrationStatus status;


}
