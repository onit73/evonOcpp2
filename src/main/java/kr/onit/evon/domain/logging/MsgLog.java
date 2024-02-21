package kr.onit.evon.domain.logging;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name="TLOG_MESSAGE")
@ToString
public class MsgLog {
    @Id
    @Column(name = "ts")
    private Long ts;

    @Column(name = "logTimestamp")
    private Timestamp logTimestamp; // b1, a1, d1 ...

    @Column(name = "logType")
    private String logType; // request message

    @Column(name = "recvTimestamp")
    private Timestamp recvTimestamp; // response message

    @Column(name = "recvMessage")
    private String recvMessage; // T..?

    @Column(name = "recvMessageType")
    private String recvMessageType;

    @Column(name = "recvURL")
    private String recvURL; // 00078921 sid 6자리 + cid 2자리, 앞자리 0 절삭 없음

    @Column(name = "recvSessionId")
    private String recvSessionId; // IPv4

    @Column(name = "sourceCpId")
    private long sourceCpId; // S..?

    @Column(name = "sourceConnectorId")
    private int sourceConnectorId;

    @Column(name = "recvPayload")
    private String recvPayload;

    @Column(name = "sendTimestamp")
    private Timestamp sendTimestamp;


    @Column(name = "sendMessage")
    private String sendMessage;

    @Column(name = "sendMessageType")
    private String sendMessageType;

    @Column(name = "sendURL")
    private String sendURL;

    @Column(name = "sendSessionId")
    private String sendSessionId;

    @Column(name = "targetCpId")
    private long targetCpId;

    @Column(name = "targetConnectorId")
    private int targetConnectorId;

    @Column(name = "sendPayload")
    private String sendPayload;

}
