package kr.dbinc.evon.ocpp.operations.datatransfer.handler;

import static kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferMessage.GET_ID_TAG_PROFILE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.operations.datatransfer.VendorConst;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.GetIdTagProfileRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.GetIdTagPriceResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.GetIdTagProfileResponse;
import kr.dbinc.evon.ocpp.service.MessageForwardService;
import kr.dbinc.evon.ocpp.service.PriceService;
import kr.dbinc.evon.session.ChargePoint;

@Component
public class GetIdTagProfileHandler extends AbstractDataTransferHandler{

    private final MessageForwardService forwardService;
    private final PriceService priceService;

    @Autowired
    public GetIdTagProfileHandler(JsonObjectMapper objectMapper, MessageForwardService forwardService, PriceService priceService) {
        super(objectMapper);
        this.forwardService = forwardService;
        this.priceService = priceService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        GetIdTagProfileRequest profileRequest = (GetIdTagProfileRequest) request;
        GetIdTagPriceResponse response = forwardService.getIdTagProfile(profileRequest.getIdTag(), chargePoint);

        float price = priceService.getPrice(chargePoint.getChargeId(), "1", null);
        return GetIdTagProfileResponse.builder()
                .unitPrice(response.getPrice())
                .wholeChargedEnergy(1)
                .wholeChargedPrice((int)price)
                .status("Accepted")
                .build();
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS))
            return true;
        return false;
    }

    @Override
    protected String getMessageId() {
        return GET_ID_TAG_PROFILE;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return GetIdTagProfileRequest.class;
    }
}
