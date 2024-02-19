package kr.dbinc.evon.ocpp.operations.heartbeat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

import kr.dbinc.evon.ocpp.types.ResponseType;
import kr.dbinc.evon.util.DateUtil;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeartbeatResponse implements ResponseType {
    private ZonedDateTime currentTime;
}
