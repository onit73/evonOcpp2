package kr.dbinc.evon.ocpp.repository.charging.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ChargingDto {

    private String orderKey;

    private String sid;
    private String cid;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private int chargingWh;

    private String stationName;
    private String stationAddress;

    @QueryProjection
    public ChargingDto(String orderKey,
                       String sid,
                       String cid,
                       LocalDateTime startAt,
                       LocalDateTime endAt,
                       double chargingWh,
                       String stationName,
                       String stationAddress
    ) {
        this.orderKey = orderKey;
        this.sid = sid;
        this.cid = cid;
        this.startAt = startAt;
        this.endAt = endAt;
        this.chargingWh = (int)chargingWh;
        this.stationName = stationName;
        this.stationAddress = stationAddress;
    }
}
