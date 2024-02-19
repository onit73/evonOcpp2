package kr.dbinc.evon.ocpp.repository.profile.query;

import kr.dbinc.evon.domain.profile.QChargingProfile;
import kr.dbinc.evon.domain.profile.QChargingSchedule;
import kr.dbinc.evon.domain.profile.QSchedulePeriod;
import kr.dbinc.evon.domain.profile.ChargingProfile;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ChargingProfileRepositoryImpl implements ProfileQueryRepository{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public ChargingProfileRepositoryImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<ChargingProfile> findFetchAllById(long chargingProfileId) {
        QChargingProfile cp = QChargingProfile.chargingProfile;
        QChargingSchedule cs = QChargingSchedule.chargingSchedule;
        QSchedulePeriod sp = QSchedulePeriod.schedulePeriod;
        ChargingProfile chargingProfile = queryFactory.selectFrom(cp)
                .join(cs).on(cp.id.eq(cs.chargingProfile.id)).fetchJoin()
                .join(sp).on(cs.id.eq(sp.chargingSchedule.id)).fetchJoin()
                .where(cp.id.eq(chargingProfileId))
                .fetchOne();

        return Optional.ofNullable(chargingProfile);
    }
}
