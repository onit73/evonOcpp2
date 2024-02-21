package kr.onit.evon.domain.locallist;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import kr.onit.evon.domain.member.Authorization;

import static javax.persistence.FetchType.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        indexes = {
                @Index(name = "version", columnList = "version_id")
        }
)
public class LocalListEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_list_entry_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "version_id")
    private LocalListVersion version;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "auth_id")
    private Authorization authorization;

    private Integer indexOfVersion;

    public LocalListEntry(LocalListVersion version, Authorization authorization, Integer index) {
        this.version = version;
        version.getEntries().add(this);
        this.authorization = authorization;
        this.indexOfVersion = index;
    }
}
