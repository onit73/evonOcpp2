package kr.onit.evon.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;

import kr.onit.evon.ocpp.component.JsonObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class SpringConfig{

    private final JsonObjectMapper jsonObjectMapper;

    @Bean(name = "typeStorePackage")
    public String typeStorePackage(){
        return "kr.dbinc.evon.ocpp.operations";
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        return jsonObjectMapper.getMapper();
    }

    @Bean
    public ThreadLocal<String> chargePointIdStore(){
        return new ThreadLocal<>();
    }

    @Bean
    public ObjectMapper objectMapper(JsonObjectMapper jsonObjectMapper){
        return jsonObjectMapper.getMapper();
    }

}
