package kr.dbinc.evon.ocpp.repository.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.dbinc.evon.domain.transaction.ChargingStatus;

@Repository
public interface ChargingStatusRepository extends JpaRepository<ChargingStatus, Long> {

}
