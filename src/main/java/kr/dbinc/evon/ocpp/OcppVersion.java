package kr.dbinc.evon.ocpp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum OcppVersion {
    V_12("ocpp1.2"),
    V_15("ocpp1.5"),
    V_16("ocpp1.6");

    private final String value;

    private static final Map<String, OcppVersion> map = Arrays.stream(OcppVersion.values())
            .collect(Collectors.toMap(OcppVersion::getValue, Function.identity()));

    public static OcppVersion fromValue(String v) {
        return map.get(v);
    }
}
