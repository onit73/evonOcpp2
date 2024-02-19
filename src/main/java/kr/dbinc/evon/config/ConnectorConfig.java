package kr.dbinc.evon.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ConnectorConfig {

    @Bean
    public ServletWebServerFactory serverFactory(CommonProperty property){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector(property.getServerPort()));
        return tomcat;
    }

    private Connector createStandardConnector(int port){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(port); //TODO 외부에서 읽어오도록 해야함
        log.info("HTTP port setup to {}", port);
        return connector;
    }
}
