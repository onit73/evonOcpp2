package kr.onit.evon.ocpp.operations.reset;

import kr.onit.evon.ocpp.types.enums.ResetType;
import kr.onit.evon.ocpp.web.dto.ResetDto;
import lombok.Getter;

@Getter
public class Reset {
    private ResetType type;

    private Reset(ResetDto request){
        this.type = request.getType();
    }

    public static Reset fromRequest(ResetDto request) {
        return new Reset(request);
    }
}
