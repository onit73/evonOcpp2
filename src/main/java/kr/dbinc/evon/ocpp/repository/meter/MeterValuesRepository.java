package kr.dbinc.evon.ocpp.repository.meter;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.meter.MeterValues;

public interface MeterValuesRepository extends JpaRepository<MeterValues, Long> {

}
