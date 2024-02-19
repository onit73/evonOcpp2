package kr.dbinc.evon.ocpp.component;

import com.fasterxml.jackson.databind.JsonNode;

import kr.dbinc.evon.ocpp.types.RequestType;
import kr.dbinc.evon.ocpp.types.ResponseType;

import java.io.IOException;

public interface ResponseFactory {

    ResponseType createResponse(JsonNode node, RequestType previousRequest) throws IOException;

}
