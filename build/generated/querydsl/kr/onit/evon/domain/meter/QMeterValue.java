package kr.onit.evon.domain.meter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMeterValue is a Querydsl query type for MeterValue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeterValue extends EntityPathBase<MeterValue> {

    private static final long serialVersionUID = -1552486730L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeterValue meterValue = new QMeterValue("meterValue");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMeterValues meterValues;

    public final ListPath<SampledValue, QSampledValue> sampledValues = this.<SampledValue, QSampledValue>createList("sampledValues", SampledValue.class, QSampledValue.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.ZonedDateTime> timestamp = createDateTime("timestamp", java.time.ZonedDateTime.class);

    public QMeterValue(String variable) {
        this(MeterValue.class, forVariable(variable), INITS);
    }

    public QMeterValue(Path<? extends MeterValue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeterValue(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeterValue(PathMetadata metadata, PathInits inits) {
        this(MeterValue.class, metadata, inits);
    }

    public QMeterValue(Class<? extends MeterValue> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.meterValues = inits.isInitialized("meterValues") ? new QMeterValues(forProperty("meterValues"), inits.get("meterValues")) : null;
    }

}

