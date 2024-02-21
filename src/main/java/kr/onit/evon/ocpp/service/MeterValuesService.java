package kr.onit.evon.ocpp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.onit.evon.domain.charger.Charger;
import kr.onit.evon.domain.charger.Connector;
import kr.onit.evon.domain.meter.MeterValue;
import kr.onit.evon.domain.meter.MeterValues;
import kr.onit.evon.domain.transaction.Transaction;
import kr.onit.evon.ocpp.operations.metervalues.MeterValuesVo;
import kr.onit.evon.ocpp.profile.request.CommonMeterValueRequest;
import kr.onit.evon.ocpp.profile.response.CommonMeterValueResponse;
import kr.onit.evon.ocpp.repository.charger.ChargerRepository;
import kr.onit.evon.ocpp.repository.meter.MeterValuesRepository;
import kr.onit.evon.ocpp.repository.transaction.TransactionRepository;
import kr.onit.evon.session.ChargePoint;
import kr.onit.evon.session.ChargePointStore;
import kr.onit.evon.util.EcosApiServer;
import kr.onit.evon.util.me.MeChargerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Slf4j
@Service
@RequiredArgsConstructor
public class MeterValuesService {

    private final MeterValuesRepository meterValuesRepository;
    private final ChargerRepository chargerRepository;
    private final TransactionRepository transactionRepository;

    private final EcosApiServer client;
    private final ObjectMapper objectMapper;

    private final ChargePointStore chargePointStore;

    private final MsgLoggingService loggingService;

    @Transactional
    public MeterValues save(MeterValuesVo meterValuesVo){
        String chargerId = meterValuesVo.getChargerId();
        Charger charger = chargerRepository.findByChargerIdJoinConnector(chargerId).orElseThrow(IllegalArgumentException::new);
        Connector connector = charger.getConnector(meterValuesVo.getConnectorId());
        Transaction transaction = null;
//        if(meterValuesVo.getTransactionId() != null){
//            transaction = transactionRepository.findById(meterValuesVo.getTransactionId()).orElse(null);
//        }
        MeterValues meterValues = MeterValues
                .builder()
                .charger(charger)
                .connector(connector)
                .transaction(transaction)
                .meterValues(new ArrayList<>())
                .build();

        meterValuesVo.getMeterValue()
                .stream()
                .map(MeterValue::of)
                .forEach(meterValue -> meterValue.matchMeterValues(meterValues));
        // TODO: 저장 하는 거는 천천히
//        meterValuesRepository.save(meterValues);

        return meterValues;
    }

}
