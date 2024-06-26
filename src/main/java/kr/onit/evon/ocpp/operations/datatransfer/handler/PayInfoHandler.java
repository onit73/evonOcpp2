package kr.onit.evon.ocpp.operations.datatransfer.handler;

import lombok.extern.slf4j.Slf4j;

import static kr.onit.evon.ocpp.operations.datatransfer.DataTransferMessage.PAYMENT_INFO;

import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.component.JsonObjectMapper;
import kr.onit.evon.ocpp.operations.datatransfer.VendorConst;
import kr.onit.evon.ocpp.operations.datatransfer.request.PaymentInfoRequest;
import kr.onit.evon.ocpp.service.MessageForwardService;
import kr.onit.evon.session.ChargePoint;

@Slf4j
@Component
public class PayInfoHandler extends AbstractDataTransferHandler {

    private final MessageForwardService forwardService;

    public PayInfoHandler(JsonObjectMapper objectMapper, MessageForwardService forwardService) {
        super(objectMapper);
        this.forwardService = forwardService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        PaymentInfoRequest infoRequest = (PaymentInfoRequest) request;

        return forwardService.payInfo(infoRequest, chargePoint);
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS)) // 코스텔
            return true;

        return false;
    }

    @Override
    protected String getMessageId() {
        return PAYMENT_INFO;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return PaymentInfoRequest.class;
    }
}
