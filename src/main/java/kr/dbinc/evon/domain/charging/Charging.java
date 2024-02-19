package kr.dbinc.evon.domain.charging;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_com_charge_mast")
public class Charging {

    @Id
    @Column(name = "order_key")
    private String id;

    @Column(name = "chargesdt")
    private LocalDateTime startAt;

    @Column(name = "chargeedt")
    private LocalDateTime endAt;

    @Column(name = "resultwh")
    private double chargingWh;

    @Column(name = "charger_key")
    private long chargerKey;
}
