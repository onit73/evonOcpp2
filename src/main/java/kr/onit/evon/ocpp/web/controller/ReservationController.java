package kr.onit.evon.ocpp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.onit.evon.ocpp.component.ResultStore;
import kr.onit.evon.ocpp.operations.cancelreservation.CancelReservationResponse;
import kr.onit.evon.ocpp.operations.reservenow.ReserveNowResponse;
import kr.onit.evon.ocpp.profile.Ocpp16Service;
import kr.onit.evon.ocpp.web.dto.CancelReservationDto;
import kr.onit.evon.ocpp.web.dto.ReserveNowDto;

import java.util.concurrent.TimeoutException;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final Ocpp16Service ocpp16Service;
    private final ResultStore resultStore;

    @GetMapping("/cancelReservation")
    public String cancelReservation(CancelReservationDto request) {
        return ocpp16Service.cancelReservation(request);
    }

    @GetMapping("/result/cancelReservation")
    public CancelReservationResponse cancelReservation(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (CancelReservationResponse) resultStore.getResult(messageId);
    }

    @GetMapping("/reserveNow")
    public String reserveNow(ReserveNowDto request) {
        return ocpp16Service.reserveNow(request);
    }

    @GetMapping("/result/reserveNow")
    public ReserveNowResponse reserveNow(@RequestParam("messageId") String messageId) throws TimeoutException {
        return (ReserveNowResponse) resultStore.getResult(messageId);
    }



}
