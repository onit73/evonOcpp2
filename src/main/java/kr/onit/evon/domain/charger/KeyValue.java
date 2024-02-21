package kr.onit.evon.domain.charger;

import lombok.*;
import javax.persistence.*;

import kr.onit.evon.ocpp.types.enums.ConfigurationKey;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TINF_CP_CONFIG")
public class KeyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cpId")
    private Charger charger;

    @Enumerated(EnumType.STRING)
    @Column(name = "configKeyId")
    private ConfigurationKey configKey;

    @Column(name = "value")
    private String configValue;

    @Column(name = "readOnly")
    private boolean readOnly;

    public void updateValue(String value){
        this.configValue = value;
    }
}
