package kr.onit.evon.ocpp.types.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Location {
    Body("Body"),
    Cable("Cable"),
    EV("EV"),

    Inlet("Inlet"),
    Outlet("Outlet");

    private final String value;

    private static final Map<String, Location> map =
            Arrays.stream(values())
                    .collect(
                            Collectors.toMap(
                                    Location::getValue,
                                    Function.identity()
                            )
                    );

    public static Location fromString(String location) {
        return map.get(location);
    }
}
