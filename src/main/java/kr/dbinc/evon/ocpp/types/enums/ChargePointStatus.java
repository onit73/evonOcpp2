package kr.dbinc.evon.ocpp.types.enums;


import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum ChargePointStatus {
    // == 작동하는 상태 == //
    Available,        // A, 1
    Preparing,        // B, 2
    Charging,         // C, 3
    SuspendedEV,      // D, 4
    SuspendedEVSE,    // E, 5
    Finishing,        // F, 6
    Reserved,         // G, 7

    // == 작동하지 않는 상태 == //
    Unavailable,      // H, 8
    Faulted;          // I, 9

    public enum Transition{
        A2(Available, Preparing),
        A3(Available, Charging),
        A4(Available, SuspendedEV),
        A5(Available, SuspendedEVSE),
        A7(Available, Reserved),
        A8(Available, Unavailable),
        A9(Available, Faulted),

        B1(Preparing, Available),
        B3(Preparing, Charging),
        B4(Preparing, SuspendedEV),
        B5(Preparing, SuspendedEVSE),
        B6(Preparing, Finishing),
        B9(Preparing, Faulted),

        C1(Charging, Available),
        C4(Charging, SuspendedEV),
        C5(Charging, SuspendedEVSE),
        C6(Charging, Finishing),
        C8(Charging, Unavailable),
        C9(Charging, Faulted),

        D1(SuspendedEV, Available),
        D3(SuspendedEV, Charging),
        D5(SuspendedEV, SuspendedEVSE),
        D6(SuspendedEV, Finishing),
        D8(SuspendedEV, Unavailable),
        D9(SuspendedEV, Faulted),

        E1(SuspendedEVSE, Available),
        E3(SuspendedEVSE, Charging),
        E4(SuspendedEVSE, SuspendedEV),
        E6(SuspendedEVSE, Finishing),
        E8(SuspendedEVSE, Unavailable),
        E9(SuspendedEVSE, Faulted),

        F1(Finishing, Available),
        F2(Finishing, Preparing),
        F8(Finishing, Unavailable),
        F9(Finishing, Faulted),

        G1(Reserved, Available),
        G2(Reserved, Preparing),
        G8(Reserved, Unavailable),
        G9(Reserved, Faulted),

        H1(Unavailable, Available),
        H2(Unavailable, Preparing),
        H3(Unavailable, Charging),
        H4(Unavailable, SuspendedEV),
        H5(Unavailable, SuspendedEVSE),
        H9(Unavailable, Faulted),

        I1(Faulted, Available),
        I2(Faulted, Preparing),
        I3(Faulted, Charging),
        I4(Faulted, SuspendedEV),
        I5(Faulted, SuspendedEVSE),
        I6(Faulted, Finishing),
        I7(Faulted, Reserved),
        I8(Faulted, Unavailable);

        private final ChargePointStatus from;
        private final ChargePointStatus to;

        Transition(ChargePointStatus from, ChargePointStatus to){
            this.from = from;
            this.to = to;
        }

        private static final Map<ChargePointStatus, Map<ChargePointStatus, Transition>> m =
                Stream.of(values())
                        .collect(
                                groupingBy(t -> t.from,
                                        () -> new EnumMap<>(ChargePointStatus.class),
                                        toMap(t -> t.to, t -> t,
                                                (x, y) -> y, () -> new EnumMap<>(ChargePointStatus.class))
                                )
                        );

        public static Transition from(ChargePointStatus from, ChargePointStatus to){
            return m.get(from).get(to);
        }
    }
}
