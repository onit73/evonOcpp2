package kr.onit.evon.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("evon")
@AllArgsConstructor
@Getter
@ToString
public class CommonProperty {
    private String apiServer;
    private int serverPort;
    private String serverIp;
}
