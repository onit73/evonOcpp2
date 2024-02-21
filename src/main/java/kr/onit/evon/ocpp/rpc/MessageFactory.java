package kr.onit.evon.ocpp.rpc;

import com.fasterxml.jackson.core.JsonParser;

import kr.onit.evon.ocpp.rpc.message.Message;

import java.io.IOException;

public interface MessageFactory {
    Message createMessage(JsonParser parser);
}
