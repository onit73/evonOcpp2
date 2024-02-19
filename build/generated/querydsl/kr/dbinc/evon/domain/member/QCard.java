package kr.dbinc.evon.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCard is a Querydsl query type for Card
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCard extends EntityPathBase<Card> {

    private static final long serialVersionUID = 1210328227L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCard card = new QCard("card");

    public final QAuthorization _super;

    public final StringPath cardNumber = createString("cardNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> expiryDate;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath idToken;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUsedDate;

    // inherited
    public final QMember member;

    // inherited
    public final QParentTag parentTag;

    //inherited
    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.AuthorizationStatus> status;

    //inherited
    public final NumberPath<Integer> usedCount;

    public QCard(String variable) {
        this(Card.class, forVariable(variable), INITS);
    }

    public QCard(Path<? extends Card> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCard(PathMetadata metadata, PathInits inits) {
        this(Card.class, metadata, inits);
    }

    public QCard(Class<? extends Card> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAuthorization(type, metadata, inits);
        this.expiryDate = _super.expiryDate;
        this.id = _super.id;
        this.idToken = _super.idToken;
        this.lastUsedDate = _super.lastUsedDate;
        this.member = _super.member;
        this.parentTag = _super.parentTag;
        this.status = _super.status;
        this.usedCount = _super.usedCount;
    }

}

