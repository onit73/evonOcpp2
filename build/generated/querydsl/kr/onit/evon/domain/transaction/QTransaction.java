package kr.onit.evon.domain.transaction;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransaction is a Querydsl query type for Transaction
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransaction extends EntityPathBase<Transaction> {

    private static final long serialVersionUID = -1096111131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransaction transaction = new QTransaction("transaction");

    public final kr.onit.evon.domain.member.QAuthorization authorization;

    public final kr.onit.evon.domain.charger.QCharger charger;

    public final kr.onit.evon.domain.profile.QChargingProfile chargingProfile;

    public final QChargingStatus chargingStatus;

    public final kr.onit.evon.domain.charger.QConnector connector;

    public final DateTimePath<java.time.LocalDateTime> endDateTime = createDateTime("endDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final kr.onit.evon.domain.member.QMember member;

    public final kr.onit.evon.domain.reservation.QReservation reservation;

    public final DateTimePath<java.time.LocalDateTime> startDateTime = createDateTime("startDateTime", java.time.LocalDateTime.class);

    public final EnumPath<kr.onit.evon.ocpp.types.enums.AuthorizationStatus> status = createEnum("status", kr.onit.evon.ocpp.types.enums.AuthorizationStatus.class);

    public QTransaction(String variable) {
        this(Transaction.class, forVariable(variable), INITS);
    }

    public QTransaction(Path<? extends Transaction> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransaction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransaction(PathMetadata metadata, PathInits inits) {
        this(Transaction.class, metadata, inits);
    }

    public QTransaction(Class<? extends Transaction> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.authorization = inits.isInitialized("authorization") ? new kr.onit.evon.domain.member.QAuthorization(forProperty("authorization"), inits.get("authorization")) : null;
        this.charger = inits.isInitialized("charger") ? new kr.onit.evon.domain.charger.QCharger(forProperty("charger")) : null;
        this.chargingProfile = inits.isInitialized("chargingProfile") ? new kr.onit.evon.domain.profile.QChargingProfile(forProperty("chargingProfile"), inits.get("chargingProfile")) : null;
        this.chargingStatus = inits.isInitialized("chargingStatus") ? new QChargingStatus(forProperty("chargingStatus")) : null;
        this.connector = inits.isInitialized("connector") ? new kr.onit.evon.domain.charger.QConnector(forProperty("connector"), inits.get("connector")) : null;
        this.member = inits.isInitialized("member") ? new kr.onit.evon.domain.member.QMember(forProperty("member")) : null;
        this.reservation = inits.isInitialized("reservation") ? new kr.onit.evon.domain.reservation.QReservation(forProperty("reservation"), inits.get("reservation")) : null;
    }

}

