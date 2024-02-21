package kr.onit.evon.ocpp.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import kr.onit.evon.ocpp.component.JsonObjectMapper;
import kr.onit.evon.ocpp.rpc.exception.NotImplementedException;
import kr.onit.evon.ocpp.rpc.message.Call;
import kr.onit.evon.ocpp.rpc.message.CallError;
import kr.onit.evon.ocpp.rpc.message.CallResult;
import kr.onit.evon.ocpp.rpc.message.Message;

import org.springframework.stereotype.Component;

@Component
public class SerializerImpl implements Serializer {

    private final JsonObjectMapper jsonObjectMapper;

    public SerializerImpl(JsonObjectMapper jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    @Override
    public String serialize(Message message) {
        if(message instanceof Call){
            return callSerialize((Call) message);
        } else if(message instanceof CallResult){
            return callResultSerialize((CallResult) message);
        } else if(message instanceof CallError){
            return callErrorSerialize((CallError) message);
        } else {
            throw new NotImplementedException("처리 할 수 없는 Message 입니다.");
        }
    }

    @Override
    public String callSerialize(Call call) {
        ObjectMapper mapper = jsonObjectMapper.getMapper();

        JsonNode payloadNode = mapper.valueToTree(call.getPayload());

        ArrayNode arrayNode = mapper.createArrayNode()
                .add(call.getType().getValue())
                .add(call.getUniqueId())
                .add(call.getAction())
                .add(payloadNode);
        String str = "";
        try {
            str = mapper.writeValueAsString(arrayNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public String callResultSerialize(CallResult callResult) {
        ObjectMapper mapper = jsonObjectMapper.getMapper();

        JsonNode payloadNode = mapper.valueToTree(callResult.getPayload());

        ArrayNode arrayNode = mapper.createArrayNode()
                .add(callResult.getType().getValue())
                .add(callResult.getUniqueId())
                .add(payloadNode);
        String str = "";
        try {
            str = mapper.writeValueAsString(arrayNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public String callErrorSerialize(CallError callError) {
        ObjectMapper mapper = jsonObjectMapper.getMapper();

        ArrayNode arrayNode = mapper.createArrayNode()
                .add(callError.getType().getValue())
                .add(callError.getUniqueId())
                .add(callError.getErrorCode().toString())
                .add(callError.getErrorDescription())
                .add("{}");
        String str = "";
        try {
            str = mapper.writeValueAsString(arrayNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
