package kr.onit.evon.domain.charger;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStation is a Querydsl query type for Station
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStation extends EntityPathBase<Station> {

    private static final long serialVersionUID = 546106011L;

    public static final QStation station = new QStation("station");

    public final StringPath address = createString("address");

    public final StringPath id = createString("id");

    public final StringPath stationName = createString("stationName");

    public QStation(String variable) {
        super(Station.class, forVariable(variable));
    }

    public QStation(Path<? extends Station> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStation(PathMetadata metadata) {
        super(Station.class, metadata);
    }

}

