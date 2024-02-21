package kr.onit.evon.ocpp.rpc.message;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum MessageType {
    CALL(2),
    CALL_RESULT(3),
    CALL_ERROR(4);

    private final int type;

    MessageType(int type) {
        this.type = type;
    }

    private static final Map<Integer, MessageType> integerToEnum =
                Stream.of(values()).collect(toMap(MessageType::getValue, e -> e));

    public static Optional<MessageType> fromInteger(int type){
        return Optional.ofNullable(integerToEnum.get(type));
    }

    public int getValue(){
        return type;
    }
}
