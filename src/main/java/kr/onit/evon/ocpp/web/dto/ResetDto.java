package kr.onit.evon.ocpp.web.dto;

import kr.onit.evon.ocpp.types.enums.ResetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetDto extends BaseDto{
    private ResetType type;
}
