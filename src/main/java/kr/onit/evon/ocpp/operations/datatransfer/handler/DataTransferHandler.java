package kr.onit.evon.ocpp.operations.datatransfer.handler;

import kr.onit.evon.session.ChargePoint;

public interface DataTransferHandler {

    String process(String data, ChargePoint chargePoint);

    boolean isMatch(String vendorId, String messageId);
}
