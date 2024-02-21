package kr.onit.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import kr.onit.evon.domain.profile.ChargingProfile;
import kr.onit.evon.ocpp.repository.profile.ChargingProfileRepository;
import kr.onit.evon.ocpp.rpc.exception.PropertyConstraintViolationException;

@Service
@RequiredArgsConstructor
public class SmartChargingService {

    private final ChargingProfileRepository chargingProfileRepository;

    public ChargingProfile findById(long chargingProfileId) {
        return chargingProfileRepository.findFetchAllById(chargingProfileId).orElseThrow(
                () -> new PropertyConstraintViolationException("존재하지 않는 ChargingProfileId입니다. chargingProfileId=" + chargingProfileId)
        );
    }
}
