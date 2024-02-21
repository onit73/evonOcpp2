
package kr.onit.evon.ocpp.repository.charging.query;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.onit.evon.ocpp.repository.charging.dto.ChargingDto;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.querydsl.core.types.Projections.*;

public class ChargingRepositoryImpl implements ChargingQueryRepository{

    private final EntityManager em;

    private final JPAQueryFactory query;

    public ChargingRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    
}
