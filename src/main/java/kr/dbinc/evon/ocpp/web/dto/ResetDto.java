package kr.dbinc.evon.ocpp.web.dto;

import kr.dbinc.evon.ocpp.types.enums.ResetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetDto extends BaseDto{
    private ResetType type;
}
