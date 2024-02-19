package kr.dbinc.evon.ocpp.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

public interface JsonObjectMapper {

    ObjectMapper getMapper();

}
