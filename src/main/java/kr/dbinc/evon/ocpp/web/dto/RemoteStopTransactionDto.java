package kr.dbinc.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteStopTransactionDto extends BaseDto{
    private Long transactionId;
}
