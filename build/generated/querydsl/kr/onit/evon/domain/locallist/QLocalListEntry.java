package kr.onit.evon.domain.locallist;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalListEntry is a Querydsl query type for LocalListEntry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalListEntry extends EntityPathBase<LocalListEntry> {

    private static final long serialVersionUID = 527598615L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocalListEntry localListEntry = new QLocalListEntry("localListEntry");

    public final kr.onit.evon.domain.member.QAuthorization authorization;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> indexOfVersion = createNumber("indexOfVersion", Integer.class);

    public final QLocalListVersion version;

    public QLocalListEntry(String variable) {
        this(LocalListEntry.class, forVariable(variable), INITS);
    }

    public QLocalListEntry(Path<? extends LocalListEntry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocalListEntry(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocalListEntry(PathMetadata metadata, PathInits inits) {
        this(LocalListEntry.class, metadata, inits);
    }

    public QLocalListEntry(Class<? extends LocalListEntry> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.authorization = inits.isInitialized("authorization") ? new kr.onit.evon.domain.member.QAuthorization(forProperty("authorization"), inits.get("authorization")) : null;
        this.version = inits.isInitialized("version") ? new QLocalListVersion(forProperty("version")) : null;
    }

}

