package kr.onit.evon.ocpp.repository.charger;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.onit.evon.domain.charger.KeyValue;
import kr.onit.evon.ocpp.types.enums.ConfigurationKey;

import java.util.Optional;
import java.util.Set;


public interface KeyValueRepository extends JpaRepository<KeyValue, String> {

    @Query("select kv from KeyValue kv where   kv.configKey = :key and id = :chargePointId")
    Optional<KeyValue> findByKeyAndChargeId(@Param("key")ConfigurationKey key, @Param("chargePointId") String chargeId);

    @Query("select kv from KeyValue kv where id = :chargePointId")
    Set<KeyValue> findAllByChargerId(@Param("chargePointId") String chargePointId);
}
