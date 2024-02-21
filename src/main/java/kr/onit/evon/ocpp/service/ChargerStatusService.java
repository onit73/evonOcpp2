package kr.onit.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.charger.ChargerStatus;
import kr.onit.evon.ocpp.repository.charger.ChargerRepository;
import kr.onit.evon.ocpp.rpc.exception.PropertyConstraintViolationException;
import kr.onit.evon.ocpp.types.enums.ChargePointStatus;
import kr.onit.evon.ocpp.types.enums.DiagnosticsStatus;
import kr.onit.evon.ocpp.types.enums.FirmwareStatus;
import kr.onit.evon.session.ChargePoint;

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
