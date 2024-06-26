package kr.onit.evon.ocpp.operations.datatransfer.handler;

import lombok.extern.slf4j.Slf4j;

import static kr.onit.evon.ocpp.operations.datatransfer.DataTransferMessage.RESULT_PRICE;

import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.component.JsonObjectMapper;
import kr.onit.evon.ocpp.operations.datatransfer.VendorConst;
import kr.onit.evon.ocpp.operations.datatransfer.request.ResultPriceRequest;
import kr.onit.evon.ocpp.service.MessageForwardService;
import kr.onit.evon.session.ChargePoint;

@Slf4j
@Component
public class ResultPriceHandler extends AbstractDataTransferHandler{

    private final MessageForwardService forwardService;

    public ResultPriceHandler(JsonObjectMapper objectMapper, MessageForwardService forwardService) {
        super(objectMapper);
        this.forwardService = forwardService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        ResultPriceRequest resultPriceRequest = (ResultPriceRequest) request;

        return forwardService.resultPrice(resultPriceRequest, chargePoint);
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS)) // 코스텔
            return true;
        return false;
    }

    @Override
    protected String getMessageId() {
        return RESULT_PRICE;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return ResultPriceRequest.class;
    }
}
