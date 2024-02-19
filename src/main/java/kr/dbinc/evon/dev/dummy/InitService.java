package kr.dbinc.evon.dev.dummy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.dbinc.evon.domain.charger.*;
import kr.dbinc.evon.domain.member.*;
import kr.dbinc.evon.domain.profile.ChargingProfile;
import kr.dbinc.evon.domain.profile.ChargingSchedule;
import kr.dbinc.evon.domain.profile.SchedulePeriod;
import kr.dbinc.evon.domain.reservation.Reservation;
import kr.dbinc.evon.domain.transaction.Transaction;
import kr.dbinc.evon.ocpp.types.enums.*;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitService {

    private final EntityManager em;

    @Transactional
    public void initDummyData(){
        Charger charger = chargerInit();

        Member member = memberInit();

        reservationInit(member, charger);
        chargingProfile();
        transaction();
    }

    public Charger chargerInit(){
        Charger charger1 = Charger.builder()
                .chargeId("99903")
                .username("ezcharger")
                .build();
        Charger charger2 = Charger.builder()
                .chargeId("1111117386")
                .username("ezcharger1")
                .build();

        em.persist(charger1);
        em.persist(charger2);

        Connector connector1 = Connector.builder()
                .connectorType(ConnectorType.DC)
                .connectorNumber(1)
                .charger(charger1)
                .build();

        Connector connector2 = Connector.builder()
                .connectorType(ConnectorType.DC)
                .connectorNumber(1)
                .charger(charger2)
                .build();

        em.persist(connector1);
        em.persist(connector2);
//
//        ChargerStatus chargerStatus1 = new ();
//        ChargerStatus chargerStatus2 = new ChargerStatus();
//
//        em.persist(chargerStatus1);
//        em.persist(chargerStatus2);

        configInit(charger1);
        configInit(charger2);

        return charger1;
    }

    private void configInit(Charger charger) {
        KeyValue authKey = KeyValue.builder()
                .charger(charger)
                .readOnly(false)
                .configKey(ConfigurationKey.AuthorizationKey)
                .configValue("12345")
                .build();

        KeyValue profileKey = KeyValue.builder()
                .charger(charger)
                .readOnly(false)
                .configKey(ConfigurationKey.SecurityProfile)
                .configValue("0")
                .build();

        em.persist(authKey);
        em.persist(profileKey);
    }

    public Member memberInit(){
        Member member = new Member("member1");
        em.persist(member);

        parentTagInit(member);

        return member;
    }

    public void parentTagInit(Member member){
        ParentTag parentTag = ParentTag.builder()
                .parentTag("PARENTTAG")
                .ownerMember(member)
                .build();

        em.persist(parentTag);

        cardInit(member, parentTag);
        carInit(member, parentTag);
    }

    public void cardInit(Member member, ParentTag parentTag){
        LocalDateTime nonExpiredDate = LocalDateTime.now().plusYears(5);
        LocalDateTime expiredDate = LocalDateTime.of(2000, 1, 1, 10, 0, 0);

        for (int i = 0; i < 50; i++) {
//            LocalDateTime selectedDate = i == 1 ? expiredDate : nonExpiredDate; // Test Case Id : 023_2할때 풀면 됨
            LocalDateTime selectedDate = nonExpiredDate;

            Card card = new Card(
                    "1234123412341234"+i,
                    parentTag,
                    member,
                    "1234123412341234"+i,
                    selectedDate);

            em.persist(card);
        }

        Card card = new Card(
                "RFID3",
                parentTag,
                member,
                "1234123412341234",
                nonExpiredDate);
        em.persist(card);
        Card card1 = new Card(
                "h!",
                parentTag,
                member,
                "1234123412341234",
                nonExpiredDate);
        em.persist(card1);

        Card findCard = em.createQuery("select c from Card c where c.idToken = :idToken", Card.class)
                .setParameter("idToken", "12341234123412341")
                .getSingleResult();

        findCard.changeStatus(AuthorizationStatus.Blocked); // Test Case Id : 023_3할때 풀면 됨

    }

    public void carInit(Member member, ParentTag parentTag){
        Car car = new Car(
                "CAR_TAG_1",
                parentTag,
                member,
                "123가 4567",
                LocalDateTime.of(2025, 1, 1, 0, 0));

        em.persist(car);
    }

    public void reservationInit(Member member, Charger charger){
        LocalDateTime nonExpiredDate = LocalDateTime.of(3000, 1, 1, 10, 0, 0);

        Reservation reservation = new Reservation(
                member,
                charger,
                nonExpiredDate,
                Reservation.Status.Reserved,
                "12341234123412340",
                "PARENTTAG"
        );

        em.persist(reservation);
    }

    public void chargingProfile(){
        ChargingProfile chargingProfile = new ChargingProfile(
                1,
                ChargingProfilePurposeType.TxProfile,
                ChargingProfileKindType.Absolute,
                RecurrencyKindType.Daily,
                LocalDateTime.now(),
                LocalDateTime.now().plusYears(1)
        );

        em.persist(chargingProfile);
        chargingSchedule(chargingProfile);

    }

    public void chargingSchedule(ChargingProfile profile){
        ChargingSchedule chargingSchedule = new ChargingSchedule(
                profile,
                300,
                LocalDateTime.now(),
                ChargingRateUnitType.W,
                0.5f
        );
        em.persist(chargingSchedule);
        schedulePeriod(chargingSchedule);
    }

    public void schedulePeriod(ChargingSchedule schedule){
        em.persist(new SchedulePeriod(schedule,0, 11000.0, 3));
        em.persist(new SchedulePeriod(schedule,28800, 6000.0, 3));
        em.persist(new SchedulePeriod(schedule,72000, 11000.0, 3));
    }

    public void transaction(){
        Authorization authorization = em.find(Authorization.class, 1L);
        Transaction transaction = Transaction.builder()
                .startDateTime(LocalDateTime.now())
                .authorization(authorization)
                .status(AuthorizationStatus.Accepted)
                .build();
        em.persist(transaction);
    }

}
