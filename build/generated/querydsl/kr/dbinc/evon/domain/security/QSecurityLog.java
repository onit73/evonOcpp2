package kr.dbinc.evon.domain.security;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSecurityLog is a Querydsl query type for SecurityLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSecurityLog extends EntityPathBase<SecurityLog> {

    private static final long serialVersionUID = 379022935L;

    public static final QSecurityLog securityLog = new QSecurityLog("securityLog");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> latestTimestamp = createDateTime("latestTimestamp", java.time.LocalDateTime.class);

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.Log> logType = createEnum("logType", kr.dbinc.evon.ocpp.types.enums.Log.class);

    public final DateTimePath<java.time.LocalDateTime> oldestTimestamp = createDateTime("oldestTimestamp", java.time.LocalDateTime.class);

    public final StringPath remoteLocation = createString("remoteLocation");

    public QSecurityLog(String variable) {
        super(SecurityLog.class, forVariable(variable));
    }

    public QSecurityLog(Path<? extends SecurityLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSecurityLog(PathMetadata metadata) {
        super(SecurityLog.class, metadata);
    }

}

