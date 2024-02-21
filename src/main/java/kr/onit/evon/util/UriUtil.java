package kr.onit.evon.util;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Objects;


public enum UriUtil {
    INSTANCE;

    public String extractChargePointId(URI uri){
        Objects.requireNonNull(uri);
        String path = uri.getPath();
        String[] strings = path.split("/");
        return strings[strings.length-1];
    }
}
