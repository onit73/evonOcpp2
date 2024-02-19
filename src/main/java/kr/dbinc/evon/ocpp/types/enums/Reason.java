package kr.dbinc.evon.ocpp.types.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import kr.dbinc.evon.ocpp.OcppVersion;

public enum Reason {
    DeAuthorized,
    EmergencyStop,
    EVDisconnected,
    HardReset,
    Local,
    Other,
    PowerLoss,
    Reboot,
    Remote,
    SoftReset,
    UnlockCommand;
}
