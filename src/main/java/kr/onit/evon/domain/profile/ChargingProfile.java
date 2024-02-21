package kr.onit.evon.domain.profile;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import kr.onit.evon.ocpp.types.enums.ChargingProfileKindType;
import kr.onit.evon.ocpp.types.enums.ChargingProfilePurposeType;
import kr.onit.evon.ocpp.types.enums.RecurrencyKindType;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "charging_profile")
public class ChargingProfile {

    @Id
    @Column(name = "charging_profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "chargingProfile", fetch = LAZY)
    private ChargingSchedule chargingSchedule;

    @Column(name = "stack_level")
    private Integer stackLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "charging_profile_purpose")
    private ChargingProfilePurposeType chargingProfilePurpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "charging_profile_kind")
    private ChargingProfileKindType chargingProfileKind;

    @Enumerated(EnumType.STRING)
    @Column(name = "recurrency_kind")
    private RecurrencyKindType recurrencyKind;

    @Column(name = "valid_from")
    private LocalDateTime validFrom;
    @Column(name = "valid_to")
    private LocalDateTime validTo;

    public ChargingProfile(
            int stackLevel,
            ChargingProfilePurposeType chargingProfilePurpose,
            ChargingProfileKindType chargingProfileKind,
            RecurrencyKindType recurrencyKind,
            LocalDateTime validFrom,
            LocalDateTime validTo)
    {
        this.stackLevel = stackLevel;
        this.chargingProfilePurpose = chargingProfilePurpose;
        this.chargingProfileKind = chargingProfileKind;
        this.recurrencyKind = recurrencyKind;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
}
