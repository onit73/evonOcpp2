package kr.onit.evon.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChargingStatus {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "charging_status_id")
    private Long id;

    // TODO: 트랜잭션 진행중에 충전기의 모드를 추적해야하는가?
    private String chargerMode;

    private Float nowUsedPower; // 전력양
    private Float nowUsedAmount; // 금액

    public void addPower(Float power){
        this.nowUsedPower =+ power;
    }
}
