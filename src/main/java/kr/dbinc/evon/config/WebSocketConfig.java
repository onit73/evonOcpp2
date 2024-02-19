package kr.dbinc.evon.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    public static final int MAX_MSG_SIZE = 8_388_608; // 8 MB for max message size

    private final WebSocketHandler handler;
    private final SecurityInterceptor authorizeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/v2/*")
                .setAllowedOrigins("*")
                .addInterceptors(authorizeInterceptor);
    }

}
