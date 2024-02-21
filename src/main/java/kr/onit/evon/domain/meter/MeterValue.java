package kr.onit.evon.domain.meter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import kr.onit.evon.ocpp.types.MeterValueVO;
import kr.onit.evon.util.DateUtil;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeterValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meter_value_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "meter_values_id")
    private MeterValues meterValues;

    @OneToMany(mappedBy = "meterValue", cascade = CascadeType.ALL)
    private List<SampledValue> sampledValues = new ArrayList<>();

    private ZonedDateTime timestamp;

    private MeterValue(MeterValueVO meterValueVO){
        this.timestamp = meterValueVO.getTimestamp();
        meterValueVO.getSampledValue().stream()
                .map(SampledValue::of)
                .forEach(sampledValues -> sampledValues.matchMeterValue(this));
    }

    public static MeterValue of(MeterValueVO meterValueVO) {
        return new MeterValue(meterValueVO);
    }

    public void matchMeterValues(MeterValues meterValues) {
        this.meterValues = meterValues;
        meterValues.getMeterValues().add(this);
    }

    @Override
    public String toString() {
        return "MeterValue{" +
                "id=" + id +
                ", sampledValues=" + sampledValues +
                ", timestamp=" + timestamp +
                '}';
    }
}
