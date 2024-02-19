
package kr.dbinc.evon.ocpp.repository.roaming;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.roaming.RoamingPrice;

public interface RoamingPriceRepository extends JpaRepository<RoamingPrice, String> {
}
