package kr.onit.evon.ocpp.profile;

import kr.onit.evon.ocpp.web.dto.CancelReservationDto;
import kr.onit.evon.ocpp.web.dto.ReserveNowDto;

public interface ReservationProfile extends Profile{

    // Initiated by Central System
    String reserveNow(ReserveNowDto request);
    String cancelReservation(CancelReservationDto request);
}
