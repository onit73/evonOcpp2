package kr.onit.evon.ocpp.component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.onit.evon.jackson.SampledValueDeserializer;
import kr.onit.evon.jackson.SampledValuedSerializer;
import kr.onit.evon.ocpp.types.dto.SampledValueRequest;

import org.springframework.stereotype.Component;

@Component
public class PolicyObjectMapper implements JsonObjectMapper{

    private final ObjectMapper objectMapper;

    public PolicyObjectMapper() {

        objectMapper = JsonMapper.builder()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .build();

        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        //응답 객체가 비어 있을 때 {}로 전송되도록 하는 설정
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // Required 속성과 Optional 속성을 구분하기 위한 속성
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);


        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(SampledValueRequest.class, new SampledValueDeserializer());
        simpleModule.addSerializer(SampledValueRequest.class, new SampledValuedSerializer());

        objectMapper.registerModules(simpleModule, new JavaTimeModule());
    }

    @Override
    public ObjectMapper getMapper() {
        return objectMapper;
    }
}
