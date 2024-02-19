package kr.dbinc.evon.domain.profile;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChargingSchedule is a Querydsl query type for ChargingSchedule
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChargingSchedule extends EntityPathBase<ChargingSchedule> {

    private static final long serialVersionUID = -1215536722L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChargingSchedule chargingSchedule = new QChargingSchedule("chargingSchedule");

    public final QChargingProfile chargingProfile;

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.ChargingRateUnitType> chargingRateUnit = createEnum("chargingRateUnit", kr.dbinc.evon.ocpp.types.enums.ChargingRateUnitType.class);

    public final NumberPath<Integer> duration = createNumber("duration", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Float> minChargingRate = createNumber("minChargingRate", Float.class);

    public final ListPath<SchedulePeriod, QSchedulePeriod> schedulePeriod = this.<SchedulePeriod, QSchedulePeriod>createList("schedulePeriod", SchedulePeriod.class, QSchedulePeriod.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> startSchedule = createDateTime("startSchedule", java.time.LocalDateTime.class);

    public QChargingSchedule(String variable) {
        this(ChargingSchedule.class, forVariable(variable), INITS);
    }

    public QChargingSchedule(Path<? extends ChargingSchedule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChargingSchedule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChargingSchedule(PathMetadata metadata, PathInits inits) {
        this(ChargingSchedule.class, metadata, inits);
    }

    public QChargingSchedule(Class<? extends ChargingSchedule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chargingProfile = inits.isInitialized("chargingProfile") ? new QChargingProfile(forProperty("chargingProfile"), inits.get("chargingProfile")) : null;
    }

}

