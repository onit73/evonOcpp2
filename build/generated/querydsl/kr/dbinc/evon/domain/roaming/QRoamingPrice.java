package kr.dbinc.evon.domain.roaming;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoamingPrice is a Querydsl query type for RoamingPrice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoamingPrice extends EntityPathBase<RoamingPrice> {

    private static final long serialVersionUID = 1134783686L;

    public static final QRoamingPrice roamingPrice = new QRoamingPrice("roamingPrice");

    public final StringPath bid = createString("bid");

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final NumberPath<Double> fee = createNumber("fee", Double.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final NumberPath<Double> unitPrice = createNumber("unitPrice", Double.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QRoamingPrice(String variable) {
        super(RoamingPrice.class, forVariable(variable));
    }

    public QRoamingPrice(Path<? extends RoamingPrice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoamingPrice(PathMetadata metadata) {
        super(RoamingPrice.class, metadata);
    }

}

