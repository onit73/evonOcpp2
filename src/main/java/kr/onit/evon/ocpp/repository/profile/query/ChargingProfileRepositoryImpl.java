package kr.onit.evon.ocpp.repository.profile.query;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.onit.evon.domain.profile.ChargingProfile;
import kr.onit.evon.domain.profile.QChargingProfile;
import kr.onit.evon.domain.profile.QChargingSchedule;
import kr.onit.evon.domain.profile.QSchedulePeriod;
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
