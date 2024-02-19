package kr.dbinc.evon.ocpp.types.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum UnitOfMeasure {
    Wh("Wh"),
    kWh("kWh"),
    varh("varh"),
    kvarh("kvarh"),
    W("W"),
    kW("kW"),
    VA("VA"),
    kVA("kVA"),
    var("var"),
    kvar("kvar"),
    A("A"),
    V("V"),
    Celsius("Celsius"),
    Fahrenheit("Fahrenheit"),
    K("K"),
    Percent("Percent");

    private final String value;

    private static final Map<String, UnitOfMeasure> map =
            Arrays.stream(values())
                    .collect(
                            Collectors.toMap(
                                    UnitOfMeasure::getValue,
                                    Function.identity()
                            )
                    );

    public static UnitOfMeasure fromString(String unit) {
        return map.get(unit);
    }
}
