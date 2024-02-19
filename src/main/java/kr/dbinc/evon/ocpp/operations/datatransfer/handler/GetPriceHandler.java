package kr.dbinc.evon.ocpp.operations.datatransfer.handler;

import static kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferMessage.GET_PRICE;

import org.springframework.stereotype.Component;

import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.operations.datatransfer.VendorConst;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.GetPriceRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.GetPriceResponse;
import kr.dbinc.evon.ocpp.service.MessageForwardService;
import kr.dbinc.evon.ocpp.service.PriceService;
import kr.dbinc.evon.session.ChargePoint;

@Component
public class GetPriceHandler extends AbstractDataTransferHandler{

    private final MessageForwardService forwardService;

    public GetPriceHandler(JsonObjectMapper objectMapper, MessageForwardService forwardService) {
        super(objectMapper);
        this.forwardService = forwardService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        GetPriceRequest getPriceRequest = (GetPriceRequest) request;

        return forwardService.getPrice(getPriceRequest, chargePoint);
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS)) // 코스텔
            return true;

        return false;
    }

    @Override
    protected String getMessageId() {
        return GET_PRICE;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return GetPriceRequest.class;
    }


}
