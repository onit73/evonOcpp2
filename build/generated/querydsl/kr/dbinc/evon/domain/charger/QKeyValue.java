package kr.dbinc.evon.domain.charger;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QKeyValue is a Querydsl query type for KeyValue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKeyValue extends EntityPathBase<KeyValue> {

    private static final long serialVersionUID = 134382307L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QKeyValue keyValue = new QKeyValue("keyValue");

    public final QCharger charger;

    public final EnumPath<kr.dbinc.evon.ocpp.types.enums.ConfigurationKey> configKey = createEnum("configKey", kr.dbinc.evon.ocpp.types.enums.ConfigurationKey.class);

    public final StringPath configValue = createString("configValue");

    public final StringPath id = createString("id");

    public final BooleanPath readOnly = createBoolean("readOnly");

    public QKeyValue(String variable) {
        this(KeyValue.class, forVariable(variable), INITS);
    }

    public QKeyValue(Path<? extends KeyValue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QKeyValue(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QKeyValue(PathMetadata metadata, PathInits inits) {
        this(KeyValue.class, metadata, inits);
    }

    public QKeyValue(Class<? extends KeyValue> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.charger = inits.isInitialized("charger") ? new QCharger(forProperty("charger")) : null;
    }

}

