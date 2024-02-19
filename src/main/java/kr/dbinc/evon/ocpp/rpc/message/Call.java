package kr.dbinc.evon.ocpp.rpc.message;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Call implements Message{

    private static final MessageType TYPE = MessageType.CALL;

    private final String uniqueId;
    private final String action;
    private final RequestType payload;


    @Override
    public MessageType getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "Call{" +
                "type='" + TYPE.getValue() + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", action='" + action + '\'' +
                ", payload=" + payload +
                '}';
    }
}
