package kr.dbinc.evon.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@DiscriminatorValue("CAR")
public class Car extends Authorization {

    private String carNumber;

    public Car(String idToken, ParentTag parentTag, Member member, String carNumber, LocalDateTime expiryDate) {
        super(idToken, parentTag, member, expiryDate);
        this.carNumber = carNumber;
    }
}
