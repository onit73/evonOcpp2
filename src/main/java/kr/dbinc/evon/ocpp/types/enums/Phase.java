package kr.dbinc.evon.ocpp.types.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Phase {
    L1("L1"),
    L2("L2"),
    L3("L3"),
    N("N"),
    L1_N("L1-N"),
    L2_N("L2-N"),
    L3_N("L3-N"),
    L1_L2("L1-L2"),
    L2_L3("L2-L3"),
    L3_L1("L3-L1");

    private final String value;

    private static final Map<String, Phase> map =
            Arrays.stream(values())
                    .collect(
                            Collectors.toMap(
                                    Phase::getValue,
                                    Function.identity()
                            )
                    );

    public static Phase fromString(String phase) {
        return map.get(phase);
    }
}
