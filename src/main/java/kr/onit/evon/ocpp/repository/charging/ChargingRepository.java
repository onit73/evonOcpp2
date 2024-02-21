package kr.onit.evon.ocpp.repository.charging;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.charging.Charging;
import kr.onit.evon.ocpp.repository.charging.query.ChargingQueryRepository;

public interface ChargingRepository extends JpaRepository<Charging, String>, ChargingQueryRepository {

}
