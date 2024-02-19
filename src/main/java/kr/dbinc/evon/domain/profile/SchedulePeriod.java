package kr.dbinc.evon.domain.profile;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "schedule_period")
public class SchedulePeriod {

    @Id
    @Column(name = "schedule_period_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "charging_schedule_id")
    private ChargingSchedule chargingSchedule;

    @Column(name = "start_period")
    private Integer startPeriod;

    @Column(name = "limits")
    private Double limit;
    @Column(name="number_phase")
    private Integer numberPhase;

    public SchedulePeriod(
            ChargingSchedule chargingSchedule,
            Integer startPeriod,
            Double limit,
            Integer numberPhase
    ) {
        this.chargingSchedule = chargingSchedule;
        this.startPeriod = startPeriod;
        this.limit = limit;
        this.numberPhase = numberPhase;
    }
}
