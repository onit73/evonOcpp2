package kr.dbinc.evon.ocpp.operations.datatransfer.handler;

import lombok.extern.slf4j.Slf4j;

import static kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferMessage.PARTIAL_CANCEL;

import org.springframework.stereotype.Component;

import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.operations.datatransfer.VendorConst;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.PartialCancelRequest;
import kr.dbinc.evon.ocpp.service.MessageForwardService;
import kr.dbinc.evon.session.ChargePoint;

@Slf4j
@Component
public class PartialCancelHandler extends AbstractDataTransferHandler{

    private final MessageForwardService forwardService;

    public PartialCancelHandler(JsonObjectMapper objectMapper, MessageForwardService forwardService) {
        super(objectMapper);
        this.forwardService = forwardService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        PartialCancelRequest cancelRequest = (PartialCancelRequest) request;
        return forwardService.partialCancel(cancelRequest, chargePoint);
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS))
            return true;
        return false;
    }

    @Override
    protected String getMessageId() {
        return PARTIAL_CANCEL;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return PartialCancelRequest.class;
    }
}
