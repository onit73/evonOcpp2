package kr.onit.evon.ocpp.repository.charging.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * kr.onit.evon.ocpp.repository.charging.dto.QChargingDto is a Querydsl Projection type for ChargingDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QChargingDto extends ConstructorExpression<ChargingDto> {

    private static final long serialVersionUID = -1028964179L;

    public QChargingDto(com.querydsl.core.types.Expression<String> orderKey, com.querydsl.core.types.Expression<String> sid, com.querydsl.core.types.Expression<String> cid, com.querydsl.core.types.Expression<java.time.LocalDateTime> startAt, com.querydsl.core.types.Expression<java.time.LocalDateTime> endAt, com.querydsl.core.types.Expression<Double> chargingWh, com.querydsl.core.types.Expression<String> stationName, com.querydsl.core.types.Expression<String> stationAddress) {
        super(ChargingDto.class, new Class<?>[]{String.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, double.class, String.class, String.class}, orderKey, sid, cid, startAt, endAt, chargingWh, stationName, stationAddress);
    }

}

