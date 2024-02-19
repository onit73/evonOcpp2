package kr.dbinc.evon.ocpp.repository.charging;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.charging.Charging;
import kr.dbinc.evon.ocpp.repository.charging.query.ChargingQueryRepository;

public interface ChargingRepository extends JpaRepository<Charging, String>, ChargingQueryRepository {

}
