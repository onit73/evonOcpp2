package kr.dbinc.evon.domain.reservation;

import lombok.*;

import javax.persistence.*;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.domain.member.Member;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        indexes = {
                @Index(name = "idTag", columnList = "idTag")
        }
)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private Member user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "charger_id")
    private Charger charger;

    private LocalDateTime expiryDate;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String idTag;
    private String parentTag;

    public void start() {
        this.status = Status.StartedTx;
    }

    public Reservation(Member user, Charger charger, LocalDateTime expiryDate, Status status, String idTag, String parentTag) {
        this.user = user;
        this.charger = charger;
        this.expiryDate = expiryDate;
        this.status = status;
        this.idTag = idTag;
        this.parentTag = parentTag;
    }

    public void cancel() {
        this.status = Status.Canceled;
    }

    public enum Status{
        Reserved,
        Canceled,
        StartedTx
    }
}
