package kr.dbinc.evon.domain.member;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("CARD")
public class Card extends Authorization {

    private String cardNumber;

    public Card(
            String idToken,
            ParentTag parentTag,
            Member member,
            String cardNumber,
            LocalDateTime expireDate
    ) {
        super(idToken,parentTag, member, expireDate);
        this.cardNumber = cardNumber;
    }

}
