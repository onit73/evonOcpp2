package kr.dbinc.evon.ocpp.repository.charger;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.charger.Connector;



public interface ConnectorRepository extends JpaRepository<Connector, Long> {
}
