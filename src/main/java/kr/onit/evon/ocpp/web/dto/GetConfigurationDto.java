package kr.onit.evon.ocpp.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class GetConfigurationDto extends BaseDto{
    private List<String> key = new ArrayList<>();
}
