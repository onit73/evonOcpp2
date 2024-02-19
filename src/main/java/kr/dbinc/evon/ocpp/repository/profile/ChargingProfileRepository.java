package kr.dbinc.evon.ocpp.repository.profile;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.domain.profile.ChargingProfile;
import kr.dbinc.evon.ocpp.repository.profile.query.ProfileQueryRepository;

import java.util.Optional;

public interface ChargingProfileRepository extends JpaRepository<ChargingProfile, Long>, ProfileQueryRepository {

    @EntityGraph(attributePaths = "chargingSchedule")
    Optional<ChargingProfile> findFetchById(long chargingProfileId);
}
