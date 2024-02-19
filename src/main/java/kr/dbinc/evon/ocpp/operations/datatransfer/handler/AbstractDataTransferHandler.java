package kr.dbinc.evon.ocpp.operations.datatransfer.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.session.ChargePoint;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@RequiredArgsConstructor
public abstract class AbstractDataTransferHandler implements DataTransferHandler{

    private final JsonObjectMapper objectMapper;

    @Override
    public String process(String data, ChargePoint chargePoint) {
        Object request = parseRequest(data, getRequestClassType());

        Object response = handle(request, chargePoint);

        return parseResponse(response);
    }

    public boolean isMatch(String vendorId, String messageId){
        return messageId.toUpperCase(Locale.ROOT).contains(getMessageId().toUpperCase(Locale.ROOT))
                && isSupported(vendorId);
    }

    protected abstract Object handle(Object request, ChargePoint chargePoint);

    protected abstract boolean isSupported(String vendorId);

    protected abstract String getMessageId();

    protected abstract Class<?> getRequestClassType();

    private <T> T parseRequest(String request, Class<T> valueType){
        ObjectMapper mapper = objectMapper.getMapper();
        try {
            return mapper.readValue(request, valueType);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Json Parsing Error", e);
        }
    }

    private String parseResponse(Object object){
        try {
            return objectMapper.getMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Json Parsing Error", e);
        }
    }
}
