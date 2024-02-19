package kr.dbinc.evon.domain.charging;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCharging is a Querydsl query type for Charging
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCharging extends EntityPathBase<Charging> {

    private static final long serialVersionUID = 547080397L;

    public static final QCharging charging = new QCharging("charging");

    public final NumberPath<Long> chargerKey = createNumber("chargerKey", Long.class);

    public final NumberPath<Double> chargingWh = createNumber("chargingWh", Double.class);

    public final DateTimePath<java.time.LocalDateTime> endAt = createDateTime("endAt", java.time.LocalDateTime.class);

    public final StringPath id = createString("id");

    public final DateTimePath<java.time.LocalDateTime> startAt = createDateTime("startAt", java.time.LocalDateTime.class);

    public QCharging(String variable) {
        super(Charging.class, forVariable(variable));
    }

    public QCharging(Path<? extends Charging> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCharging(PathMetadata metadata) {
        super(Charging.class, metadata);
    }

}

