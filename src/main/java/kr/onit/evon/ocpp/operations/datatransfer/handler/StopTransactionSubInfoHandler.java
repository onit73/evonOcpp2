package kr.onit.evon.ocpp.operations.datatransfer.handler;

import static kr.onit.evon.ocpp.operations.datatransfer.DataTransferMessage.GET_ID_TAG_PROFILE;
import static kr.onit.evon.ocpp.operations.datatransfer.DataTransferMessage.STOP_TRANSACTION_SUB_INFO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.component.JsonObjectMapper;
import kr.onit.evon.ocpp.operations.datatransfer.VendorConst;
import kr.onit.evon.ocpp.operations.datatransfer.request.GetIdTagProfileRequest;
import kr.onit.evon.ocpp.operations.datatransfer.request.StopTransactionSubInfoRequest;
import kr.onit.evon.ocpp.operations.datatransfer.response.GetIdTagProfileResponse;
import kr.onit.evon.ocpp.operations.datatransfer.response.StopTransactionSubInfoResponse;
import kr.onit.evon.session.ChargePoint;

@Component
public class StopTransactionSubInfoHandler extends AbstractDataTransferHandler{

    @Autowired
    public StopTransactionSubInfoHandler(JsonObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        StopTransactionSubInfoRequest subInfoRequest = (StopTransactionSubInfoRequest) request;

        return new StopTransactionSubInfoResponse("Accepted", "성공");
    }

    @Override
    protected boolean isSupported(String vendorId) {
        if(vendorId.equals(VendorConst.BLUENETWORKS)) // 시그넷
            return true;

        return false;
    }

    @Override
    protected String getMessageId() {
        return STOP_TRANSACTION_SUB_INFO;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return StopTransactionSubInfoRequest.class;
    }
}
