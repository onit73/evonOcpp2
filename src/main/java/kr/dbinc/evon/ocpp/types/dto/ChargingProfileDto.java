package kr.dbinc.evon.ocpp.types.dto;

import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import kr.dbinc.evon.domain.profile.ChargingProfile;
import kr.dbinc.evon.domain.profile.ChargingSchedule;
import kr.dbinc.evon.ocpp.types.enums.ChargingProfileKindType;
import kr.dbinc.evon.ocpp.types.enums.ChargingProfilePurposeType;
import kr.dbinc.evon.ocpp.types.enums.RecurrencyKindType;
import kr.dbinc.evon.util.DateUtil;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChargingProfileDto {

    private final Long chargingProfileId;
    private final Long transactionId;
    private final Integer stackLevel;
    private final ChargingProfilePurposeType chargingProfilePurpose;
    private final ChargingProfileKindType chargingProfileKind;
    private final RecurrencyKindType recurrencyKind;
    private final ZonedDateTime validFrom;
    private final ZonedDateTime validTo;

    private final ChargingScheduleDto chargingSchedule;

    public static ChargingProfileDto of(ChargingProfile chargingProfile, Long transactionId){
        ChargingSchedule chargingSchedule = chargingProfile.getChargingSchedule();

        List<ChargingSchedulePeriodDto> periodDtos = ChargingSchedulePeriodDto.of(chargingSchedule.getSchedulePeriod());
        ChargingScheduleDto chargingScheduleDto = ChargingScheduleDto.builder()
                .chargingRateUnit(chargingSchedule.getChargingRateUnit())
                .chargingSchedulePeriod(periodDtos)
                .duration(chargingSchedule.getDuration())
                .minChargingRate(chargingSchedule.getMinChargingRate())
                .build();

        ZonedDateTime validFrom = null;
        if(chargingProfile.getValidFrom() != null){
            validFrom = ZonedDateTime.of(chargingProfile.getValidFrom(), ZoneId.of("Asia/Seoul"));
        }
        ZonedDateTime validTo = null;
        if(chargingProfile.getValidTo() != null){
            validTo = ZonedDateTime.of(chargingProfile.getValidTo(), ZoneId.of("Asia/Seoul"));
        }

        return ChargingProfileDto.builder()
                .chargingProfileId(chargingProfile.getId())
                .stackLevel(chargingProfile.getStackLevel())
                .chargingProfilePurpose(chargingProfile.getChargingProfilePurpose())
                .chargingProfileKind(chargingProfile.getChargingProfileKind())
                .chargingSchedule(chargingScheduleDto)
                .transactionId(transactionId)
                .validFrom(validFrom)
                .validTo(validTo).build();
    }
}
