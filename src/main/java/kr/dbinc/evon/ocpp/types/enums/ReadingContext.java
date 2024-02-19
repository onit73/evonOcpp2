package kr.dbinc.evon.ocpp.types.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum ReadingContext {
    InterruptionBegin("Interruption.Begin"),
    InterruptionEnd("Interruption.End"),
    Other("Other"),
    SampleClock("Sample.Clock"),
    SamplePeriodic("Sample.Periodic"),
    TransactionBegin("Transaction.Begin"),
    TransactionEnd("Transaction.End"),
    Trigger("Trigger");

    private final String value;

    private static final Map<String, ReadingContext> map =
            Arrays.stream(ReadingContext.values())
                    .collect(Collectors.toMap(ReadingContext::getValue, Function.identity()));

    public static ReadingContext fromString(String context) {
        return map.get(context);
    }
}
