package kr.onit.evon.domain.meter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMeterValues is a Querydsl query type for MeterValues
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeterValues extends EntityPathBase<MeterValues> {

    private static final long serialVersionUID = -882448259L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeterValues meterValues1 = new QMeterValues("meterValues1");

    public final kr.onit.evon.domain.charger.QCharger charger;

    public final kr.onit.evon.domain.charger.QConnector connector;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<MeterValue, QMeterValue> meterValues = this.<MeterValue, QMeterValue>createList("meterValues", MeterValue.class, QMeterValue.class, PathInits.DIRECT2);

    public final kr.onit.evon.domain.transaction.QTransaction transaction;

    public QMeterValues(String variable) {
        this(MeterValues.class, forVariable(variable), INITS);
    }

    public QMeterValues(Path<? extends MeterValues> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeterValues(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeterValues(PathMetadata metadata, PathInits inits) {
        this(MeterValues.class, metadata, inits);
    }

    public QMeterValues(Class<? extends MeterValues> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.charger = inits.isInitialized("charger") ? new kr.onit.evon.domain.charger.QCharger(forProperty("charger")) : null;
        this.connector = inits.isInitialized("connector") ? new kr.onit.evon.domain.charger.QConnector(forProperty("connector"), inits.get("connector")) : null;
        this.transaction = inits.isInitialized("transaction") ? new kr.onit.evon.domain.transaction.QTransaction(forProperty("transaction"), inits.get("transaction")) : null;
    }

}

