
package kr.onit.evon.ocpp.repository.roaming;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.roaming.RoamingPrice;

public interface RoamingPriceRepository extends JpaRepository<RoamingPrice, String> {
}
