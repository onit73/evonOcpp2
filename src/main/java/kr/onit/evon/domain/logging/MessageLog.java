package kr.onit.evon.domain.logging;

import lombok.*;

import javax.persistence.*;

import kr.onit.evon.domain.charger.Charger;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name="TLOG_MESSAGE")
public class MessageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "recvURL")
    private Charger charger;

    @JoinColumn(name = "sourceCpId")
    private int sourceCpId;

    @Column(name="recvPayload", columnDefinition = "TEXT")
    private String message;

    @Column(name = "sendTimestamp")
    private LocalDateTime sendDate;
}
