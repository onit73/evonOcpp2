package kr.dbinc.evon.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParentTag is a Querydsl query type for ParentTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParentTag extends EntityPathBase<ParentTag> {

    private static final long serialVersionUID = 1114300637L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParentTag parentTag1 = new QParentTag("parentTag1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember ownerMember;

    public final StringPath parentTag = createString("parentTag");

    public QParentTag(String variable) {
        this(ParentTag.class, forVariable(variable), INITS);
    }

    public QParentTag(Path<? extends ParentTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParentTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParentTag(PathMetadata metadata, PathInits inits) {
        this(ParentTag.class, metadata, inits);
    }

    public QParentTag(Class<? extends ParentTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ownerMember = inits.isInitialized("ownerMember") ? new QMember(forProperty("ownerMember")) : null;
    }

}

