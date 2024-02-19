package kr.dbinc.evon.domain.member;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import kr.dbinc.evon.ocpp.types.enums.AuthorizationStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;


@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        indexes = @Index(name = "id_tag", columnList = "id_token")
)
public class Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorization_id")
    private Long id;

    @Column(name = "id_token", unique = true)
    private String idToken;

    @ColumnDefault("0")
    private Integer usedCount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_tag_id")
    private ParentTag parentTag;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime expiryDate;

    @Enumerated(EnumType.STRING)
    private AuthorizationStatus status;

    private LocalDateTime lastUsedDate;

    public Authorization(
            String idToken,
            ParentTag parentTag,
            Member member,
            LocalDateTime expiryDate) {
        this.idToken = idToken;
        this.parentTag = parentTag;
        this.member = member;
        this.usedCount = 0;
        this.status = AuthorizationStatus.Accepted;
        this.lastUsedDate = LocalDateTime.now();
        this.expiryDate = expiryDate;

    }

    public void hit(){
        this.lastUsedDate = LocalDateTime.now();
        usedCount++;
    }

    public boolean isBlocked(){
        return this.status == AuthorizationStatus.Blocked;
    }

    public void changeStatus(AuthorizationStatus status){
        this.status = status;
    }

    public boolean isExpired(){
        return expiryDate.isBefore(LocalDateTime.now());
    }

}
