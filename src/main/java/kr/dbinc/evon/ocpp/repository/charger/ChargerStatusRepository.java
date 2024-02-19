package kr.dbinc.evon.ocpp.repository.charger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kr.dbinc.evon.domain.charger.ChargerStatus;

public interface ChargerStatusRepository extends JpaRepository<ChargerStatus, String> {

    @Transactional
    @Query(value = "insert into TINF_CP_STATUS (csId\r\n" + //
            "                    ,   cpId\r\n" + //
            "                    ,   modelId\r\n" + //
            "                    ,   manage\r\n" + //
            "                    ,   availibility\r\n" + //
            "                    ,   operating\r\n" + //
            "                    ,   ts\r\n" + //
            "                    ,   connectionYN\r\n" + //
            "                    ,   vendorId)" +
            " values (" +
            " ( select cscp.csId from TINF_CS_CP as cscp left join TINF_CP cp on cscp.cpId = cp.id where cp.chargeBoxSerialNumber = :chargeBoxSerialNumber )\r\n" + //
                    " ,   ( select id from TINF_CP where chargeBoxSerialNumber = :chargeBoxSerialNumber )\r\n" + //
                    " ,   ( select modelId from TINF_CP where chargeBoxSerialNumber = :chargeBoxSerialNumber )\r\n" + //
                    " ,   '1'\r\n" + //
                    " ,   '1'\r\n" + //
                    " ,   '1'\r\n" + //
                    " ,   NOW()\r\n" + //
                    " ,   'Y'\r\n" + //
                    " ,  (SELECT A.serviceCompanyId \r\n" + //
                    "       FROM TINF_CS A\r\n" + //
                    "       INNER JOIN TINF_CS_CP B\r\n" + //
                    "         ON A.id=B.csId\r\n" + //
                    "       INNER JOIN TINF_CP C\r\n" + //
                    "         ON B.cpId = C.id\r\n" + //
                    "       where C.chargeBoxSerialNumber = :chargeBoxSerialNumber)" +
            " ) " +
            " on duplicate key " +
            "update ts  = NOW() " +
            "  ,   connectionYN    = 'Y';", nativeQuery = true)
    void insertCPConnectionStatus(@Param("chargeBoxSerialNumber") String chargeBoxSerialNumber);

    @Transactional
    @Query(value = "update TINF_CP_STATUS" +
            " set ts = NOW()" +
            "   , connectionYN = 'N'" +
            " where csId = ( select cscp.csId from TINF_CS_CP as cscp left join TINF_CP cp on cscp.cpId = cp.id where cp.chargeBoxSerialNumber = :chargeBoxSerialNumber )" +
            " and cpId = ( select id from TINF_CP where chargeBoxSerialNumber = :chargeBoxSerialNumber and protocol like 'OCPP%' )" +
            " and modelId = ( select modelId from TINF_CP where chargeBoxSerialNumber = :chargeBoxSerialNumber );", nativeQuery = true)
    void updateCPConnectionStatus(@Param("chargeBoxSerialNumber") String chargeBoxSerialNumber);
}
