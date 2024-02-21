package kr.onit.evon.domain.profile;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChargingProfile is a Querydsl query type for ChargingProfile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChargingProfile extends EntityPathBase<ChargingProfile> {

    private static final long serialVersionUID = -637009974L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChargingProfile chargingProfile = new QChargingProfile("chargingProfile");

    public final EnumPath<kr.onit.evon.ocpp.types.enums.ChargingProfileKindType> chargingProfileKind = createEnum("chargingProfileKind", kr.onit.evon.ocpp.types.enums.ChargingProfileKindType.class);

    public final EnumPath<kr.onit.evon.ocpp.types.enums.ChargingProfilePurposeType> chargingProfilePurpose = createEnum("chargingProfilePurpose", kr.onit.evon.ocpp.types.enums.ChargingProfilePurposeType.class);

    public final QChargingSchedule chargingSchedule;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<kr.onit.evon.ocpp.types.enums.RecurrencyKindType> recurrencyKind = createEnum("recurrencyKind", kr.onit.evon.ocpp.types.enums.RecurrencyKindType.class);

    public final NumberPath<Integer> stackLevel = createNumber("stackLevel", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> validFrom = createDateTime("validFrom", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> validTo = createDateTime("validTo", java.time.LocalDateTime.class);

    public QChargingProfile(String variable) {
        this(ChargingProfile.class, forVariable(variable), INITS);
    }

    public QChargingProfile(Path<? extends ChargingProfile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChargingProfile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChargingProfile(PathMetadata metadata, PathInits inits) {
        this(ChargingProfile.class, metadata, inits);
    }

    public QChargingProfile(Class<? extends ChargingProfile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chargingSchedule = inits.isInitialized("chargingSchedule") ? new QChargingSchedule(forProperty("chargingSchedule"), inits.get("chargingSchedule")) : null;
    }

}

