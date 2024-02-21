package kr.onit.evon.domain.charger;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import kr.onit.evon.ocpp.types.enums.ChargePointStatus;
import kr.onit.evon.ocpp.types.enums.DiagnosticsStatus;
import kr.onit.evon.ocpp.types.enums.FirmwareStatus;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;
import static kr.onit.evon.ocpp.types.enums.ChargePointStatus.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "db_com_charger_status")
public class ChargerStatus {

    @Id
    @Column(name = "chargerid")
    private String id;

    @Column(name = "regdt")
    private LocalDateTime updatedAt;

    @Column(name = "mode")
    private String mode;

    @Column(name = "status")
    private String meStatus;

    @Column(name = "ezchstatus")
    private String ezStatus;

    @Column(name = "ip")
    private String ip;
//
//    @Enumerated(EnumType.STRING)
//    private ChargePointStatus status;
//
//    @Enumerated(EnumType.STRING)
//    private DiagnosticsStatus diagnosticsStatus;
//
//    @Enumerated(EnumType.STRING)
//    private FirmwareStatus firmwareStatus;
//
//    LocalDateTime lastReceiveTime;
//
//    public ChargerStatus(Charger charger) {
//        this.status = Available;
//        this.diagnosticsStatus = DiagnosticsStatus.Idle;
//        this.firmwareStatus = FirmwareStatus.Idle;
//        this.charger = charger;
//    }
//
//    public void updateDiagnosticStatus(DiagnosticsStatus diagnosticsStatus) {
//        this.diagnosticsStatus = diagnosticsStatus;
//    }
//
//    public void updateChargerStatus(ChargePointStatus chargePointStatus){
//        Transition from = Transition.from(this.status, chargePointStatus);
//        if(from != null)
//            this.status = chargePointStatus;
//    }
//
//    public void updateFirmwareStatus(FirmwareStatus firmwareStatus) {
//        this.firmwareStatus = firmwareStatus;
//    }
//
//    public void received(){
//        this.lastReceiveTime = LocalDateTime.now();
//    }

}
