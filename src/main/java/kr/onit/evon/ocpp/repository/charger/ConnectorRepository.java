package kr.onit.evon.ocpp.repository.charger;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.charger.Connector;



public interface ConnectorRepository extends JpaRepository<Connector, Long> {
}
