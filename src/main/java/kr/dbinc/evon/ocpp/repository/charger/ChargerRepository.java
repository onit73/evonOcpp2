package kr.dbinc.evon.ocpp.repository.charger;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.dbinc.evon.domain.charger.Charger;

import java.util.List;
import java.util.Optional;

public interface ChargerRepository extends JpaRepository<Charger, Long> {

    @EntityGraph(attributePaths = "connectors")
    @Query("select c from Charger c where c.chargeId = :chargeId")
    Optional<Charger> findByChargerIdJoinConnector(@Param(value = "chargeId")String chargeId);

    Optional<Charger> findByChargeId(String chargeId);
}
