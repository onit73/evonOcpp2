package kr.dbinc.evon.domain.meter;


import lombok.*;

import javax.persistence.*;

import kr.dbinc.evon.ocpp.types.*;
import kr.dbinc.evon.ocpp.types.enums.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SampledValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sampled_value_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "meter_value_id")
    private MeterValue meterValue;

    private String measuredValue;

    @Enumerated(EnumType.STRING)
    private ReadingContext context;

    @Enumerated(EnumType.STRING)
    private ValueFormat format;

    @Enumerated(EnumType.STRING)
    private Measurand measurand;

    @Enumerated(EnumType.STRING)
    private Phase phase;

    @Enumerated(EnumType.STRING)
    private Location location;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unit;

    private SampledValue(SampledValueVO sampledValueVO){
        this.measuredValue = sampledValueVO.getValue();
        this.context = sampledValueVO.getContext();
        this.format = sampledValueVO.getFormat();
        this.measurand = sampledValueVO.getMeasurand();
        this.phase = sampledValueVO.getPhase();
        this.location = sampledValueVO.getLocation();
        this.unit = sampledValueVO.getUnit();
    }

    public static SampledValue of(SampledValueVO sampledValueVO) {
        return new SampledValue(sampledValueVO);
    }

    public void matchMeterValue(MeterValue meterValue) {
        this.meterValue = meterValue;
        meterValue.getSampledValues().add(this);
    }

    public static SampledValue empty(){
        return SampledValue.builder().measuredValue("0").build();
    }

    @Override
    public String toString() {
        return "SampledValue{" +
                "id=" + id +
                ", measuredValue='" + measuredValue + '\'' +
                ", context=" + context +
                ", format=" + format +
                ", measurand=" + measurand +
                ", phase=" + phase +
                ", location=" + location +
                ", unit=" + unit +
                '}';
    }
}
