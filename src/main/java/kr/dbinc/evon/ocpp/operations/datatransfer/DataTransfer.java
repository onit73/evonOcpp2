package kr.dbinc.evon.ocpp.operations.datatransfer;

import com.fasterxml.jackson.databind.JsonNode;

import kr.dbinc.evon.ocpp.types.CiString;
import lombok.Getter;

@Getter
public class DataTransfer {
    private final CiString vendorId;
    private final CiString messageId;
    private final String data;

    public DataTransfer(DataTransferRequest request) {
        this.vendorId = new CiString(request.getVendorId(), CiString.Length.TYPE255);
        this.messageId = new CiString(request.getMessageId(), CiString.Length.TYPE50);
        this.data = request.getData();
    }

    public static DataTransfer fromRequest(DataTransferRequest request){
        return new DataTransfer(request);
    }
}
