package kr.dbinc.evon.domain.meter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSampledValue is a Querydsl query type for SampledValue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSampledValue extends EntityPathBase<SampledValue> {

    private static final long serialVersionUID = -740355971L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSampledValue sampledValue = new QSampledValue("sampledValue");

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.ReadingContext> context = createEnum("context", kr.dbinc.evon.ocpp.types.enums.ReadingContext.class);

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.ValueFormat> format = createEnum("format", kr.dbinc.evon.ocpp.types.enums.ValueFormat.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.Location> location = createEnum("location", kr.dbinc.evon.ocpp.types.enums.Location.class);

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.Measurand> measurand = createEnum("measurand", kr.dbinc.evon.ocpp.types.enums.Measurand.class);

    public final StringPath measuredValue = createString("measuredValue");

    public final QMeterValue meterValue;

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.Phase> phase = createEnum("phase", kr.dbinc.evon.ocpp.types.enums.Phase.class);

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.UnitOfMeasure> unit = createEnum("unit", kr.dbinc.evon.ocpp.types.enums.UnitOfMeasure.class);

    public QSampledValue(String variable) {
        this(SampledValue.class, forVariable(variable), INITS);
    }

    public QSampledValue(Path<? extends SampledValue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSampledValue(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSampledValue(PathMetadata metadata, PathInits inits) {
        this(SampledValue.class, metadata, inits);
    }

    public QSampledValue(Class<? extends SampledValue> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.meterValue = inits.isInitialized("meterValue") ? new QMeterValue(forProperty("meterValue"), inits.get("meterValue")) : null;
    }

}

