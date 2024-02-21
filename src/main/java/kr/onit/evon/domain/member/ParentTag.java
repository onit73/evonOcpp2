package kr.onit.evon.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ParentTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_tag_id")
    private Long id;

    private String parentTag;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "owner_member_id")
    private Member ownerMember;
}
