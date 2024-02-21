package kr.onit.evon.ocpp.web.request;


import kr.onit.evon.ocpp.web.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendCommandRequest extends BaseDto {

    private String vendorId;
    private String command;
}
