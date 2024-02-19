package kr.dbinc.evon.ocpp.types;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import kr.dbinc.evon.ocpp.types.dto.SampledValueRequest;
import kr.dbinc.evon.ocpp.types.enums.*;

@Getter
@ToString
public class SampledValueVO {
    private final String value;
    private final ReadingContext context;
    private final ValueFormat format;
    private final Measurand measurand;
    private final Phase phase;
    private final Location location;
    private final UnitOfMeasure unit;

    private SampledValueVO(SampledValueRequest request){
        this.value = request.getValue();
        this.context = request.getContext();
        this.format = request.getFormat();
        this.measurand = request.getMeasurand();
        this.phase = request.getPhase();
        this.location = request.getLocation();
        this.unit = request.getUnit();
    }
    public static List<SampledValueVO> fromRequests(List<SampledValueRequest> sampledValue) {
        List<SampledValueVO> result = new ArrayList<>();
        for (SampledValueRequest request : sampledValue) {
            result.add(fromRequest(request));
        }
        return result;
    }

    public static SampledValueVO fromRequest(SampledValueRequest request){
        return new SampledValueVO(request);
    }
}
