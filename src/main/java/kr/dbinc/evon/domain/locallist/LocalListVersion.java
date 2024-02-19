package kr.dbinc.evon.domain.locallist;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        indexes = {
                @Index(name = "version", unique = true, columnList = "version")
        }
)
public class LocalListVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_list_version_id")
    private Long id;

    private Long version;

    @OneToMany(mappedBy = "version")
    private List<LocalListEntry> entries = new ArrayList<>();

    public LocalListVersion(Long version) {
        this.version = version;
    }
}
