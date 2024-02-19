package kr.dbinc.evon.domain.profile;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchedulePeriod is a Querydsl query type for SchedulePeriod
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchedulePeriod extends EntityPathBase<SchedulePeriod> {

    private static final long serialVersionUID = 1457920574L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSchedulePeriod schedulePeriod = new QSchedulePeriod("schedulePeriod");

    public final QChargingSchedule chargingSchedule;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> limit = createNumber("limit", Double.class);

    public final NumberPath<Integer> numberPhase = createNumber("numberPhase", Integer.class);

    public final NumberPath<Integer> startPeriod = createNumber("startPeriod", Integer.class);

    public QSchedulePeriod(String variable) {
        this(SchedulePeriod.class, forVariable(variable), INITS);
    }

    public QSchedulePeriod(Path<? extends SchedulePeriod> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSchedulePeriod(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSchedulePeriod(PathMetadata metadata, PathInits inits) {
        this(SchedulePeriod.class, metadata, inits);
    }

    public QSchedulePeriod(Class<? extends SchedulePeriod> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chargingSchedule = inits.isInitialized("chargingSchedule") ? new QChargingSchedule(forProperty("chargingSchedule"), inits.get("chargingSchedule")) : null;
    }

}

