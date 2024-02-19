package kr.dbinc.evon.ocpp.operations.datatransfer.handler;

import static kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferMessage.SMS_MESSAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.operations.datatransfer.VendorConst;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.SmsMessageRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.SmsMessageResponse;
import kr.dbinc.evon.ocpp.service.MessageForwardService;
import kr.dbinc.evon.session.ChargePoint;

@Component
public class SmsMessageHandler extends AbstractDataTransferHandler{

    private final MessageForwardService forwardService;

    @Autowired
    public SmsMessageHandler(JsonObjectMapper objectMapper, MessageForwardService forwardService) {
        super(objectMapper);
        this.forwardService = forwardService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        SmsMessageRequest messageRequest = (SmsMessageRequest) request;

        return forwardService.smsMessage(messageRequest, chargePoint);
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS))
            return true;
        return false;
    }

    @Override
    protected String getMessageId() {
        return SMS_MESSAGE;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return SmsMessageRequest.class;
    }
}
