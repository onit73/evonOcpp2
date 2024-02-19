package kr.dbinc.evon.ocpp.operations.datatransfer.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.operations.datatransfer.VendorConst;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.GetPricingProfileRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.GetPricingProfileResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.PricingProfileResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.PricingScheduleResponse;
import kr.dbinc.evon.ocpp.service.PriceService;
import kr.dbinc.evon.session.ChargePoint;

import static kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferMessage.GET_PRICING_PROFILE;
import static kr.dbinc.evon.ocpp.operations.datatransfer.PriceType.Member;
import static kr.dbinc.evon.ocpp.operations.datatransfer.PriceType.NonMember;

import java.util.Arrays;
import java.util.Collections;

@Component
public class GetPricingProfileHandler extends AbstractDataTransferHandler{

    private final PriceService priceService;

    @Autowired
    public GetPricingProfileHandler(JsonObjectMapper objectMapper, PriceService priceService) {
        super(objectMapper);
        this.priceService = priceService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        float chargerPrice = priceService.getPrice(chargePoint.getChargeId(), "1", null);
//        float nonMemberPrice = priceService.getNonMemberPrice();

        PricingScheduleResponse memberSchedule = new PricingScheduleResponse(0, chargerPrice);
        PricingScheduleResponse nonMemberSchedule = new PricingScheduleResponse(0, chargerPrice);

        PricingProfileResponse memberProfile = new PricingProfileResponse(Member, "KRW", Collections.singletonList(memberSchedule));
        PricingProfileResponse nonMemberProfile = new PricingProfileResponse(NonMember, "KRW", Collections.singletonList(nonMemberSchedule));

        return new GetPricingProfileResponse(1, 1, Arrays.asList(memberProfile, nonMemberProfile));
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS)) // 코스텔
            return true;

        return false;
    }

    @Override
    protected String getMessageId() {
        return GET_PRICING_PROFILE;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return GetPricingProfileRequest.class;
    }
}
