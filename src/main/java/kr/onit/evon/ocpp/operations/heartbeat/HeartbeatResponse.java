package kr.onit.evon.ocpp.operations.heartbeat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

import kr.onit.evon.ocpp.types.ResponseType;
import kr.onit.evon.util.DateUtil;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeartbeatResponse implements ResponseType {
    private ZonedDateTime currentTime;
}
