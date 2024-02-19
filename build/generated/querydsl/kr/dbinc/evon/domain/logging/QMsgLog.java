package kr.dbinc.evon.domain.logging;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMsgLog is a Querydsl query type for MsgLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMsgLog extends EntityPathBase<MsgLog> {

    private static final long serialVersionUID = 2010474131L;

    public static final QMsgLog msgLog = new QMsgLog("msgLog");

    public final DateTimePath<java.sql.Timestamp> logTimestamp = createDateTime("logTimestamp", java.sql.Timestamp.class);

    public final StringPath logType = createString("logType");

    public final StringPath recvMessage = createString("recvMessage");

    public final StringPath recvMessageType = createString("recvMessageType");

    public final StringPath recvPayload = createString("recvPayload");

    public final StringPath recvSessionId = createString("recvSessionId");

    public final DateTimePath<java.sql.Timestamp> recvTimestamp = createDateTime("recvTimestamp", java.sql.Timestamp.class);

    public final StringPath recvURL = createString("recvURL");

    public final StringPath sendMessage = createString("sendMessage");

    public final StringPath sendMessageType = createString("sendMessageType");

    public final StringPath sendPayload = createString("sendPayload");

    public final StringPath sendSessionId = createString("sendSessionId");

    public final DateTimePath<java.sql.Timestamp> sendTimestamp = createDateTime("sendTimestamp", java.sql.Timestamp.class);

    public final StringPath sendURL = createString("sendURL");

    public final NumberPath<Integer> sourceConnectorId = createNumber("sourceConnectorId", Integer.class);

    public final NumberPath<Long> sourceCpId = createNumber("sourceCpId", Long.class);

    public final NumberPath<Integer> targetConnectorId = createNumber("targetConnectorId", Integer.class);

    public final NumberPath<Long> targetCpId = createNumber("targetCpId", Long.class);

    public final NumberPath<Long> ts = createNumber("ts", Long.class);

    public QMsgLog(String variable) {
        super(MsgLog.class, forVariable(variable));
    }

    public QMsgLog(Path<? extends MsgLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMsgLog(PathMetadata metadata) {
        super(MsgLog.class, metadata);
    }

}

