package kr.onit.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.member.Authorization;
import kr.onit.evon.domain.reservation.Reservation;
import kr.onit.evon.ocpp.operations.cancelreservation.CancelReservation;
import kr.onit.evon.ocpp.operations.reservenow.ReserveNow;
import kr.onit.evon.ocpp.operations.reservenow.ReserveNowRequest;
import kr.onit.evon.ocpp.repository.charger.ChargerRepository;
import kr.onit.evon.ocpp.repository.member.AuthorizationRepository;
import kr.onit.evon.ocpp.repository.reservation.ReservationRepository;
import kr.onit.evon.ocpp.rpc.exception.PropertyConstraintViolationException;
import kr.onit.evon.ocpp.types.IdTagInfo;
import kr.onit.evon.ocpp.types.enums.AuthorizationStatus;
import kr.onit.evon.util.CommonUtil;
import kr.onit.evon.util.DateUtil;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final AuthorizationRepository authorizationRepository;
    private final ChargerRepository chargerRepository;
    private final AuthorizeService authorizeService;


    public ReserveNowRequest create(ReserveNow reserveNow, String chargePointId){
        IdTagInfo idTagInfo = authorizeService.authorizeToken(reserveNow.getIdTag());
        if( !(idTagInfo.getStatus() == AuthorizationStatus.Accepted) )
            throw new PropertyConstraintViolationException("올바르지 않은 IdToken입니다. [IdToken = " + reserveNow.getIdTag() + "]");

        Authorization authorization = authorizationRepository
                .findByIdToken(reserveNow.getIdTag().getValue())
                .orElseThrow(
                        () -> new PropertyConstraintViolationException("존재하지 않는 충전기입니다. [ChargePointId = " + chargePointId + "]")
                );
        String id = CommonUtil.removeLeadingZeroPrefix(chargePointId);
        Charger charger = chargerRepository
                .findByChargeId(id)
                .orElseThrow(
                        () -> new PropertyConstraintViolationException("존재하지 않는 충전기입니다. [ChargePointId = " + chargePointId + "]")
                );

        Long reservationId = save(reserveNow, authorization, charger);

        return ReserveNowRequest.builder()
                        .connectorId(reserveNow.getConnectorId())
                        .expiryDate(DateUtil.INSTANCE.getNowUTCDate(reserveNow.getExpiryDate()))
                        .idTag(reserveNow.getIdTag().getValue())
                        .reservationId(reservationId)
                        .parentIdTag(authorization.getParentTag().getParentTag())
                        .build();
    }

    public Long save(ReserveNow reserveNow, Authorization authorization, Charger charger){
        Reservation reservation = new Reservation(
                authorization.getMember(),
                charger,
                reserveNow.getExpiryDate(),
                Reservation.Status.Reserved,
                reserveNow.getIdTag().getValue(),
                authorization.getParentTag().getParentTag()
        );
        reservationRepository.saveAndFlush(reservation);
        return reservation.getId();
    }

    public Reservation start(Long reservationId){
        if(reservationId == null) return null;

        Reservation reservation = find(reservationId);
        reservation.start();
        return reservation;
    }

    public Reservation find(Long reservationId) {
        return reservationRepository
                .findById(reservationId)
                .orElseThrow(
                        () -> new PropertyConstraintViolationException(String.format("존재하지 않는 Reservation Id 입니다. Reservation Id : [%d]", reservationId))
                );
    }

    public void cancel(CancelReservation cancelReservation) {
        Reservation reservation = reservationRepository.findById(cancelReservation.getReservationId()).orElseThrow(
                () -> new PropertyConstraintViolationException(
                        "존재하지 않는 Reservation 입니다. [Reservation Id = " + cancelReservation.getReservationId() + "]"
                )
        );
        reservation.cancel();
    }

}
