package kr.onit.evon.ocpp.repository.security;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.charger.KeyValue;
import kr.onit.evon.domain.charger.QCharger;
import kr.onit.evon.domain.charger.QKeyValue;
import kr.onit.evon.ocpp.repository.charging.dto.QChargingDto;
import kr.onit.evon.ocpp.types.enums.ConfigurationKey;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

import javax.persistence.EntityManager;

@Repository
public class SecurityQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public SecurityQueryRepository(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    public String getPassword(String username){

        QKeyValue cpConf = QKeyValue.keyValue;
        return queryFactory
                .select(cpConf.configValue)
                .from(cpConf)
                .where(
                    cpConf.id.eq(username),
                    cpConf.configKey.eq(ConfigurationKey.AuthorizationKey)
                )
                .fetchOne(); 
    }

    public String getSecurityProfileLevel(String chargePointId){

        
        QKeyValue cpConf = QKeyValue.keyValue;

        return queryFactory.select(cpConf.configValue)
                .from(cpConf)
                .where(
                        cpConf.id.eq(chargePointId),
                        cpConf.configKey.eq(ConfigurationKey.SecurityProfile)
                ).fetchOne();
    }
}
