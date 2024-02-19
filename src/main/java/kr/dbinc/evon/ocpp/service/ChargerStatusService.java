package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.domain.charger.ChargerStatus;
import kr.dbinc.evon.ocpp.repository.charger.ChargerRepository;
import kr.dbinc.evon.ocpp.rpc.exception.PropertyConstraintViolationException;
import kr.dbinc.evon.ocpp.types.enums.ChargePointStatus;
import kr.dbinc.evon.ocpp.types.enums.DiagnosticsStatus;
import kr.dbinc.evon.ocpp.types.enums.FirmwareStatus;
import kr.dbinc.evon.session.ChargePoint;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class ChargerStatusService {

    private final ChargerRepository chargerRepository;
    private final EntityManager em;

    public void updateDiagnosticStatus(DiagnosticsStatus diagnosticsStatus, String chargePoint){
//        ChargerStatus status = getChargerStatus(chargePoint);
//
//        status.updateDiagnosticStatus(diagnosticsStatus);
    }


//    public void updateFirmwareStatus(FirmwareStatus firmwareStatus, String chargePoint){
//        ChargerStatus status = getChargerStatus(chargePoint);
//
//        status.updateFirmwareStatus(firmwareStatus);
//    }

//    private ChargerStatus getChargerStatus(String chargePoint){
//        Charger charger = chargerRepository.findByChargeId(chargePoint).orElseThrow(
//                () -> new PropertyConstraintViolationException("존재하지 않는 충전기입니다. [chargePointId = " + chargePoint + "]")
//        );
//
//        return charger.getStatus();
//    }

    @Transactional
    public void received(String ChargePointId) {
//        ChargerStatus status = getChargerStatus(ChargePointId);
//        status.received();
    }
}
