package kr.onit.evon.domain.meter;

import lombok.*;

import javax.persistence.*;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.charger.Connector;
import kr.onit.evon.domain.transaction.Transaction;
import kr.onit.evon.ocpp.rpc.exception.GenericErrorException;
import kr.onit.evon.ocpp.types.enums.Measurand;
import kr.onit.evon.ocpp.types.enums.ReadingContext;
import kr.onit.evon.ocpp.types.enums.UnitOfMeasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.FetchType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class MeterValues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meter_values_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "charger_id")
    private Charger charger;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "connector_id")
    private Connector connector;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Builder.Default
    @OneToMany(mappedBy = "meterValues", cascade = CascadeType.ALL)
    private List<MeterValue> meterValues  = new ArrayList<>();

    public int getChargingWh(){
        for (MeterValue meterValue : meterValues) {
            SampledValue now = getChargingValue(meterValue);

            int value = (int)Float.parseFloat(now.getMeasuredValue());

            // kWh일 경우 Wh단위로 변환해서 보내야 함
            if(now.getUnit() == UnitOfMeasure.kWh){
                return value * 1000;
            }else if(now.getUnit() == UnitOfMeasure.Wh){
                return value;
            }else if(now.getUnit() == UnitOfMeasure.W) {
                return value;
            }
        }
        throw new GenericErrorException("EnergyActiveImportRegister 값으로부터 전력량 측정에 실패하였습니다.");
    }

    public SampledValue getChargingValue(MeterValue meterValue) {
        return meterValue.getSampledValues().stream()
                .filter(sampledValue -> sampledValue.getMeasurand() == Measurand.EnergyActiveImportRegister)
                .findFirst()
                .orElseThrow(() -> new GenericErrorException("EnergyActiveImportRegister 값으로부터 전력량 측정에 실패하였습니다."));
    }

    @Override
    public String toString() {
        return "MeterValues{" +
                "id=" + id +
                ", charger=" + charger +
                ", connector=" + connector +
                ", transaction=" + transaction +
                ", meterValues=" + meterValues +
                '}';
    }
}
