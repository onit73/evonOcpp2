package kr.dbinc.evon.ocpp.repository.profile.query;

import java.util.Optional;

import kr.dbinc.evon.domain.profile.ChargingProfile;

public interface ProfileQueryRepository {

    Optional<ChargingProfile> findFetchAllById(long chargingProfileId);
}
