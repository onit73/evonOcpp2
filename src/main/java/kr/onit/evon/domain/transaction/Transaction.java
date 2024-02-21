package kr.onit.evon.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.charger.Connector;
import kr.onit.evon.domain.member.Authorization;
import kr.onit.evon.domain.member.Member;
import kr.onit.evon.domain.profile.ChargingProfile;
import kr.onit.evon.domain.reservation.Reservation;
import kr.onit.evon.ocpp.types.enums.AuthorizationStatus;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "authorization_id")
    private Authorization authorization;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "charger_id")
    private Charger charger;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "connector_id")
    private Connector connector;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "charging_status_id")
    private ChargingStatus chargingStatus;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "charging_profile_id")
    private ChargingProfile chargingProfile;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    private AuthorizationStatus status;

    public void stop() {
        this.endDateTime = LocalDateTime.now();
    }
}
