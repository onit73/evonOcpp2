package kr.onit.evon.domain.locallist;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocalListVersion is a Querydsl query type for LocalListVersion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalListVersion extends EntityPathBase<LocalListVersion> {

    private static final long serialVersionUID = -2135669955L;

    public static final QLocalListVersion localListVersion = new QLocalListVersion("localListVersion");

    public final ListPath<LocalListEntry, QLocalListEntry> entries = this.<LocalListEntry, QLocalListEntry>createList("entries", LocalListEntry.class, QLocalListEntry.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QLocalListVersion(String variable) {
        super(LocalListVersion.class, forVariable(variable));
    }

    public QLocalListVersion(Path<? extends LocalListVersion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalListVersion(PathMetadata metadata) {
        super(LocalListVersion.class, metadata);
    }

}

