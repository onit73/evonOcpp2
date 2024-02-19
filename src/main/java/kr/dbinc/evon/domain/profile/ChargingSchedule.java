package kr.dbinc.evon.domain.profile;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import kr.dbinc.evon.ocpp.types.enums.ChargingRateUnitType;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "charging_schedule")
public class ChargingSchedule {

    @Id
    @Column(name = "charging_schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "charging_profile_id")
    private ChargingProfile chargingProfile;

    @OneToMany(mappedBy = "chargingSchedule")
    private List<SchedulePeriod> schedulePeriod;

    @Column(name = "duration")
    private Integer duration;
    @Column(name = "start_schedule")
    private LocalDateTime startSchedule;

    @Enumerated(EnumType.STRING)
    @Column(name = "charging_rate_unit")
    private ChargingRateUnitType chargingRateUnit;
    @Column(name = "min_charging_rate")
    private Float minChargingRate;

    public ChargingSchedule(
            ChargingProfile chargingProfile,
            int duration,
            LocalDateTime startSchedule,
            ChargingRateUnitType chargingRateUnit,
            float minChargingRate) {
        this.chargingProfile = chargingProfile;
        this.duration = duration;
        this.startSchedule = startSchedule;
        this.chargingRateUnit = chargingRateUnit;
        this.minChargingRate = minChargingRate;
    }
}
