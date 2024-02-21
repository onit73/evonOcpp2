package kr.onit.evon.ocpp.repository.meter;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.meter.MeterValues;

public interface MeterValuesRepository extends JpaRepository<MeterValues, Long> {

}
