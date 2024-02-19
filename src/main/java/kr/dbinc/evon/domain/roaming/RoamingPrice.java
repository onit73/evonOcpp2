package kr.dbinc.evon.domain.roaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "db_me_price")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoamingPrice {

    @Id
    @Column(name = "bid")
    private String bid;

    @Column(name = "unitprice")
    private double unitPrice;

    @Column(name = "fee")
    private double fee;

    @Column(name = "regdt")
    private LocalDateTime createAt;

    @Column(name = "updatedt")
    private LocalDateTime updatedAt;

    @Column(name = "type")
    private int type;
}
