package kr.dbinc.evon.ocpp.types.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Getter
public enum AvailabilityType {
    Inoperative("Inoperative"),
    Operative("Operative");

    private final String value;

    private static Map<String, AvailabilityType> map =
            Arrays.stream(values()).collect(
                    Collectors.toMap(AvailabilityType::getValue, Function.identity())
            );

    public static AvailabilityType fromString(String value){
        return map.get(value);
    }
}
