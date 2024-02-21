package kr.onit.evon.domain.transaction;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChargingStatus is a Querydsl query type for ChargingStatus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChargingStatus extends EntityPathBase<ChargingStatus> {

    private static final long serialVersionUID = -363234468L;

    public static final QChargingStatus chargingStatus = new QChargingStatus("chargingStatus");

    public final StringPath chargerMode = createString("chargerMode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Float> nowUsedAmount = createNumber("nowUsedAmount", Float.class);

    public final NumberPath<Float> nowUsedPower = createNumber("nowUsedPower", Float.class);

    public QChargingStatus(String variable) {
        super(ChargingStatus.class, forVariable(variable));
    }

    public QChargingStatus(Path<? extends ChargingStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChargingStatus(PathMetadata metadata) {
        super(ChargingStatus.class, metadata);
    }

}

