package kr.dbinc.evon.ocpp.rpc;

import org.springframework.web.socket.WebSocketSession;

import kr.dbinc.evon.ocpp.rpc.message.Message;

import java.io.IOException;
import java.text.ParseException;
import java.util.function.Consumer;

public interface MessageHandler{
    void handleMessage(Message message, WebSocketSession session) throws IOException, ParseException;
}
