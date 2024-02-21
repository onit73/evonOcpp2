package kr.onit.evon.domain.charger;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChargerStatus is a Querydsl query type for ChargerStatus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChargerStatus extends EntityPathBase<ChargerStatus> {

    private static final long serialVersionUID = 75188727L;

    public static final QChargerStatus chargerStatus = new QChargerStatus("chargerStatus");

    public final StringPath ezStatus = createString("ezStatus");

    public final StringPath id = createString("id");

    public final StringPath ip = createString("ip");

    public final StringPath meStatus = createString("meStatus");

    public final StringPath mode = createString("mode");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QChargerStatus(String variable) {
        super(ChargerStatus.class, forVariable(variable));
    }

    public QChargerStatus(Path<? extends ChargerStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChargerStatus(PathMetadata metadata) {
        super(ChargerStatus.class, metadata);
    }

}

