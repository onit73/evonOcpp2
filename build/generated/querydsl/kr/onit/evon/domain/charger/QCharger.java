package kr.onit.evon.domain.charger;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCharger is a Querydsl query type for Charger
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCharger extends EntityPathBase<Charger> {

    private static final long serialVersionUID = -1112662619L;

    public static final QCharger charger = new QCharger("charger");

    public final StringPath chargeId = createString("chargeId");

    public final StringPath chargerId = createString("chargerId");

    public final NumberPath<Integer> chargerStatus = createNumber("chargerStatus", Integer.class);

    public final NumberPath<Integer> cid = createNumber("cid", Integer.class);

    public final ListPath<Connector, QConnector> connectors = this.<Connector, QConnector>createList("connectors", Connector.class, QConnector.class, PathInits.DIRECT2);

    public final NumberPath<Float> fixedPrice = createNumber("fixedPrice", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Float> operationFee = createNumber("operationFee", Float.class);

    public final NumberPath<Double> priceRate = createNumber("priceRate", Double.class);

    public final NumberPath<Integer> priceType = createNumber("priceType", Integer.class);

    public final StringPath stationKey = createString("stationKey");

    public final NumberPath<Integer> unitPriceType = createNumber("unitPriceType", Integer.class);

    public final StringPath username = createString("username");

    public QCharger(String variable) {
        super(Charger.class, forVariable(variable));
    }

    public QCharger(Path<? extends Charger> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCharger(PathMetadata metadata) {
        super(Charger.class, metadata);
    }

}

