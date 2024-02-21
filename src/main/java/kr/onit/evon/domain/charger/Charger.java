package kr.onit.evon.domain.charger;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import kr.onit.evon.domain.TimeBaseEntity;
import kr.onit.evon.ocpp.rpc.exception.PropertyConstraintViolationException;
import kr.onit.evon.ocpp.types.enums.ChargePointStatus;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VINF_CP_INFO")
//indexes = @Index(name = "cid", columnList = "charge_id")
public class Charger{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "csId")
    private String stationKey;

    @Column(name = "cpId")
    private int cid;

    @Column(name = "chargeBoxSerialNumber")
    private String chargeId; // 11122

    @Column(name = "chargePointSerialNumber")
    private String chargerId; // 00011122

    @Builder.Default
    @OneToMany(mappedBy = "charger", fetch = LAZY)
    private List<Connector> connectors = new ArrayList<>();

    private String username; // 기본 인증을 위한 값

    @Column(name = "PriceFixed")
    private float fixedPrice; // 고정 단가

    @Column(name = "pricerate")
    private Double priceRate;

    @Column(name = "OperationFee")
    private float operationFee; // 운영 요금

    @Column(name = "UnitPriceType")
    private int unitPriceType;

    @Column(name = "PriceType")
    private int priceType;

    @Column(name = "operYn")
    private int chargerStatus; // 0:설치전, 1:설치중, 2:운영중, 3:고장, 4:삭제


    public Connector getConnector(int connectorId) {
        if(connectorId == 0) return connectors.get(0);

        for (Connector connector : connectors) {
            if (connector.getConnectorNumber() == connectorId)
                return connector;
        }
        throw new PropertyConstraintViolationException(chargeId + "번 충전기에 해당 커넥터가 존재하지 않습니다. ConnectorId : " + connectorId);
    }

//    public boolean isPreparing(){
//        return this.status.getStatus() == ChargePointStatus.Preparing;
//    }

}
