package kr.onit.evon.ocpp.rpc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;

import kr.onit.evon.ocpp.component.PreviousRequestStore;
import kr.onit.evon.ocpp.component.ResponseFactory;
import kr.onit.evon.ocpp.component.TypeStore;
import kr.onit.evon.ocpp.rpc.message.Call;
import kr.onit.evon.ocpp.rpc.message.CallError;
import kr.onit.evon.ocpp.rpc.message.CallResult;
import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.ResponseType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CallFactoryImpl implements CallFactory{

    private final ResponseFactory responseFactory;
    private final PreviousRequestStore previousRequestStore;
    private final TypeStore typeStore;


    @Override
    public Call createCall(JsonParser parser) throws IOException {
        parser.nextToken();
        String uniqueId = parser.getValueAsString();

        parser.nextToken();
        String action = parser.getValueAsString();

        Class<? extends RequestType> actionClass = typeStore.findRequestClass(action);

        parser.nextToken();

        RequestType payload = parser.readValueAs(actionClass);

        return Call.builder()
                .uniqueId(uniqueId)
                .action(action)
                .payload(payload)
                .build();
    }

    @Override
    public CallResult createCallResult(JsonParser parser) throws IOException {
        parser.nextToken();
        String uniqueId = parser.getValueAsString();

        parser.nextToken();
        JsonNode node = parser.readValueAsTree();

        RequestType previousRequest = previousRequestStore.getRequest(uniqueId);

        ResponseType payload = responseFactory.createResponse(node, previousRequest);

        return CallResult.builder()
                .uniqueId(uniqueId)
                .payload(payload)
                .build();
    }

    @Override
    public CallError createCallError(JsonParser parser) throws IOException{
        return null;
    }

}
