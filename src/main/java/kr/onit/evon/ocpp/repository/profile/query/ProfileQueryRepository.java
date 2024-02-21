package kr.onit.evon.ocpp.repository.profile.query;

import java.util.Optional;

import kr.onit.evon.domain.profile.ChargingProfile;

public interface ProfileQueryRepository {

    Optional<ChargingProfile> findFetchAllById(long chargingProfileId);
}
