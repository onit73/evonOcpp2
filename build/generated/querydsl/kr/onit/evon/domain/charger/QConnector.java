package kr.onit.evon.domain.charger;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QConnector is a Querydsl query type for Connector
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QConnector extends EntityPathBase<Connector> {

    private static final long serialVersionUID = -1970921484L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QConnector connector = new QConnector("connector");

    public final QCharger charger;

    public final NumberPath<Integer> connectorNumber = createNumber("connectorNumber", Integer.class);

    public final EnumPath<ConnectorType> connectorType = createEnum("connectorType", ConnectorType.class);

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public QConnector(String variable) {
        this(Connector.class, forVariable(variable), INITS);
    }

    public QConnector(Path<? extends Connector> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QConnector(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QConnector(PathMetadata metadata, PathInits inits) {
        this(Connector.class, metadata, inits);
    }

    public QConnector(Class<? extends Connector> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.charger = inits.isInitialized("charger") ? new QCharger(forProperty("charger")) : null;
    }

}

