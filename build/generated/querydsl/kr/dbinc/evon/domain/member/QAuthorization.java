package kr.dbinc.evon.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuthorization is a Querydsl query type for Authorization
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthorization extends EntityPathBase<Authorization> {

    private static final long serialVersionUID = 1257131078L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuthorization authorization = new QAuthorization("authorization");

    public final DateTimePath<java.time.LocalDateTime> expiryDate = createDateTime("expiryDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath idToken = createString("idToken");

    public final DateTimePath<java.time.LocalDateTime> lastUsedDate = createDateTime("lastUsedDate", java.time.LocalDateTime.class);

    public final QMember member;

    public final QParentTag parentTag;

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.AuthorizationStatus> status = createEnum("status", kr.dbinc.evon.ocpp.types.enums.AuthorizationStatus.class);

    public final NumberPath<Integer> usedCount = createNumber("usedCount", Integer.class);

    public QAuthorization(String variable) {
        this(Authorization.class, forVariable(variable), INITS);
    }

    public QAuthorization(Path<? extends Authorization> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuthorization(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuthorization(PathMetadata metadata, PathInits inits) {
        this(Authorization.class, metadata, inits);
    }

    public QAuthorization(Class<? extends Authorization> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.parentTag = inits.isInitialized("parentTag") ? new QParentTag(forProperty("parentTag"), inits.get("parentTag")) : null;
    }

}

