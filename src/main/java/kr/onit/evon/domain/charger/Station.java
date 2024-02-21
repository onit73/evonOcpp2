package kr.onit.evon.domain.charger;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_com_station")
public class Station {

    @Id
    @Column(name = "station_key")
    private String id;

    @Column(name = "stationname")
    private String stationName;

    @Column(name = "roadaddrAll")
    private String address;
}
