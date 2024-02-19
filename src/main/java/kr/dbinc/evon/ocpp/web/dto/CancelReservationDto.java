package kr.dbinc.evon.ocpp.web.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelReservationDto extends BaseDto{
    private Long reservationId;
}
