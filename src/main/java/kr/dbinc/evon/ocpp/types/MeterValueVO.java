package kr.dbinc.evon.ocpp.types;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import kr.dbinc.evon.ocpp.types.dto.MeterValueRequest;
import kr.dbinc.evon.util.DateUtil;

@Getter
@ToString
public class MeterValueVO {
    private final ZonedDateTime timestamp;
    private final List<SampledValueVO> sampledValue;

    private MeterValueVO(MeterValueRequest request){
        this.timestamp =  request.getTimestamp();
        this.sampledValue = request.getSampledValue().stream()
                            .map(SampledValueVO::fromRequest)
                            .collect(Collectors.toList());
    }

    public static MeterValueVO fromRequest(MeterValueRequest request) {
        return new MeterValueVO(request);
    }

    public static List<MeterValueVO> fromRequests(List<MeterValueRequest> transactionData) {
        return transactionData.stream()
                .map(MeterValueVO::fromRequest)
                .collect(Collectors.toList());
    }
}
