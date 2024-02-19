package kr.dbinc.evon.ocpp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import kr.dbinc.evon.ocpp.operations.datatransfer.DataTransfer;
import kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.handler.DataTransferHandler;
import kr.dbinc.evon.ocpp.rpc.exception.NotSupportedException;
import kr.dbinc.evon.ocpp.types.enums.DataTransferStatus;
import kr.dbinc.evon.session.ChargePoint;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataTransferService {

    private final List<DataTransferHandler> handlers;

    public DataTransferResponse dataTransfer(DataTransfer dataTransfer, ChargePoint chargePoint) {
        DataTransferStatus status = validation(dataTransfer);
        String result = "";

        if(status.equals(DataTransferStatus.Accepted)){
            String data = dataTransfer.getData();
            String vendorId = dataTransfer.getVendorId().getValue();
            String messageId = dataTransfer.getMessageId().getValue();
            log.info("Data Transfer Request Data={}", data);

            result = handlers.stream()
                    .filter(handler -> handler.isMatch(vendorId, messageId))
                    .findAny()
                    .orElseThrow(NotSupportedException::new)
                    .process(data, chargePoint);
        }

        return DataTransferResponse.builder()
                .status(status)
                .data(result)
                .build();
    }

    public DataTransferStatus validation(DataTransfer dataTransfer){
        return DataTransferStatus.Accepted;
    }

}
