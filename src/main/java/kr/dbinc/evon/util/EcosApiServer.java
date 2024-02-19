package kr.dbinc.evon.util;

import com.google.common.net.HttpHeaders;

import kr.dbinc.evon.config.CommonProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Component
public class EcosApiServer {

    private final WebClient webClient;

    public EcosApiServer(CommonProperty commonProperty){

        String serverUrl = commonProperty.getApiServer();
        log.trace("error");
        this.webClient = WebClient.builder()
                .baseUrl(serverUrl)
                .defaultHeader("Server-Ip", commonProperty.getServerIp())
                .defaultHeader("Server-Port", String.valueOf(commonProperty.getServerPort()))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public String postCallApiServer(String uri, Object json){
        return webClient.post()
                .uri(uri)
                .bodyValue(json)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorReturn((e)-> {
                    e.printStackTrace();
                    return true;
                } ,"ERROR")
                .block();
    }
}
