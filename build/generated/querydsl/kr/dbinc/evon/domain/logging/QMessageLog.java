package kr.dbinc.evon.domain.logging;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessageLog is a Querydsl query type for MessageLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessageLog extends EntityPathBase<MessageLog> {

    private static final long serialVersionUID = -453496755L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMessageLog messageLog = new QMessageLog("messageLog");

    public final kr.dbinc.evon.domain.charger.QCharger charger;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final DateTimePath<java.time.LocalDateTime> sendDate = createDateTime("sendDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> sourceCpId = createNumber("sourceCpId", Integer.class);

    public QMessageLog(String variable) {
        this(MessageLog.class, forVariable(variable), INITS);
    }

    public QMessageLog(Path<? extends MessageLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMessageLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMessageLog(PathMetadata metadata, PathInits inits) {
        this(MessageLog.class, metadata, inits);
    }

    public QMessageLog(Class<? extends MessageLog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.charger = inits.isInitialized("charger") ? new kr.dbinc.evon.domain.charger.QCharger(forProperty("charger")) : null;
    }

}

