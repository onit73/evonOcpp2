package kr.onit.evon.ocpp.operations.metervalues;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

import kr.onit.evon.ocpp.types.MeterValueVO;

@Getter
@ToString
public class MeterValuesVo {
    private final int connectorId;
    private final Long transactionId;
    private final List<MeterValueVO> meterValue;

    private final String chargerId;

    private MeterValuesVo(MeterValuesRequest request, String chargerId){
        this.connectorId = request.getConnectorId();
        this.transactionId = request.getTransactionId();
        this.meterValue = request.getMeterValue().stream()
                        .map(MeterValueVO::fromRequest)
                        .collect(Collectors.toList());
        this.chargerId = chargerId;
    }

    public static MeterValuesVo fromRequest(MeterValuesRequest request, String chargerId) {
        return new MeterValuesVo(request, chargerId);
    }
}
