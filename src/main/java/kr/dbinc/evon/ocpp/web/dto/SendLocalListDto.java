package kr.dbinc.evon.ocpp.web.dto;

import kr.dbinc.evon.ocpp.types.enums.UpdateType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendLocalListDto extends BaseDto{
    private Long listVersion;
    private UpdateType updateType;
}
