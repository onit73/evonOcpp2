package kr.dbinc.evon.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCar is a Querydsl query type for Car
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCar extends EntityPathBase<Car> {

    private static final long serialVersionUID = -1900619807L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCar car = new QCar("car");

    public final QAuthorization _super;

    public final StringPath carNumber = createString("carNumber");

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

    public QCar(String variable) {
        this(Car.class, forVariable(variable), INITS);
    }

    public QCar(Path<? extends Car> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCar(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCar(PathMetadata metadata, PathInits inits) {
        this(Car.class, metadata, inits);
    }

    public QCar(Class<? extends Car> type, PathMetadata metadata, PathInits inits) {
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

