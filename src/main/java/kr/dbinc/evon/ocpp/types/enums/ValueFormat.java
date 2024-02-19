package kr.dbinc.evon.ocpp.types.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum ValueFormat {
    Raw("Raw"),
    SignedData("SignedData");

    private final String value;

    private static final Map<String, ValueFormat> map =
            Arrays.stream(values())
                    .collect(
                            Collectors.toMap(
                                    ValueFormat::getValue,
                                    Function.identity()
                            )
                    );

    public static ValueFormat fromString(String format) {
        List<Integer> collect = Arrays.stream(new int[]{1, 2, 3}).boxed().collect(Collectors.toList());
        return map.get(format);
    }
}
