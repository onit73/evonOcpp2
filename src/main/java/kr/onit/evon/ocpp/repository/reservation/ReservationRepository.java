package kr.onit.evon.ocpp.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.reservation.Reservation;

import static kr.onit.evon.domain.reservation.Reservation.*;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query("select r from Reservation r where r.charger.chargeId = :chargerPointId and r.status = :status")
    Optional<Reservation> findByChargerAndStatus(
            @Param("chargerPointId") String chargerPointId,
            @Param("status") Status status);
}
