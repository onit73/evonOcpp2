package kr.onit.evon.ocpp.component;

import com.fasterxml.jackson.databind.JsonNode;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.ResponseType;

import java.io.IOException;

public interface ResponseFactory {

    ResponseType createResponse(JsonNode node, RequestType previousRequest) throws IOException;

}
