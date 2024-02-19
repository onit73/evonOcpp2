package kr.dbinc.evon.ocpp.component;

import com.fasterxml.jackson.databind.JsonNode;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.ResponseType;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ResponseFactoryImpl implements ResponseFactory{

    private final TypeStore typeStore;
    private final JsonObjectMapper jsonObjectMapper;

    public ResponseFactoryImpl(TypeStore typeStore, JsonObjectMapper jsonObjectMapper) {
        this.typeStore = typeStore;
        this.jsonObjectMapper = jsonObjectMapper;
    }

    @Override
    public ResponseType createResponse(JsonNode node, RequestType previousRequest) throws IOException {
        Class<? extends ResponseType> clazz = typeStore.findResponseClass(previousRequest);
        return jsonObjectMapper.getMapper()
                .treeToValue(node, clazz);
    }
}
