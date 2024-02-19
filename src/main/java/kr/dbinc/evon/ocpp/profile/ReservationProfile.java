package kr.dbinc.evon.ocpp.profile;

import kr.dbinc.evon.ocpp.web.dto.CancelReservationDto;
import kr.dbinc.evon.ocpp.web.dto.ReserveNowDto;

public interface ReservationProfile extends Profile{

    // Initiated by Central System
    String reserveNow(ReserveNowDto request);
    String cancelReservation(CancelReservationDto request);
}
