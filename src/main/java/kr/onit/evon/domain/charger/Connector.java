package kr.onit.evon.domain.charger;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "connector")
public class Connector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connector_id")
    private Long Id;

    @Column(name = "connector_number")
    private Integer connectorNumber;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "charger_id")
    private Charger charger;

    @Enumerated(EnumType.STRING)
    @Column(name = "connector_type")
    private ConnectorType connectorType;
}
