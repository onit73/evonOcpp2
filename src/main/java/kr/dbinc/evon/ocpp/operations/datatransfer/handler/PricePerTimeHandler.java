package kr.dbinc.evon.ocpp.operations.datatransfer.handler;

import lombok.extern.slf4j.Slf4j;

import static kr.dbinc.evon.ocpp.operations.datatransfer.DataTransferMessage.*;

import org.springframework.stereotype.Component;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.ocpp.component.JsonObjectMapper;
import kr.dbinc.evon.ocpp.operations.datatransfer.VendorConst;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.PricePerTimeRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.PricePerMemberResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.PricePerNonMemberPriceResponse;
import kr.dbinc.evon.ocpp.operations.datatransfer.response.PricePerTimeResponse;
import kr.dbinc.evon.ocpp.repository.charger.ChargerRepository;
import kr.dbinc.evon.ocpp.service.PriceService;
import kr.dbinc.evon.session.ChargePoint;
import kr.dbinc.evon.session.PricePerTable;
@Slf4j
@Component
public class PricePerTimeHandler extends AbstractDataTransferHandler{
    private final PricePerTable pricePerTable;
    private final ChargerRepository chargerRepository;
    private final PriceService priceService;

    public PricePerTimeHandler(JsonObjectMapper objectMapper,PricePerTable pricePerTable , ChargerRepository chargerRepository,PriceService priceService) {
        super(objectMapper);
        this.pricePerTable = pricePerTable;
        this.chargerRepository = chargerRepository;
        this.priceService = priceService;
    }

    @Override
    protected Object handle(Object request, ChargePoint chargePoint) {
        PricePerTimeRequest pricePerTimeRequest = (PricePerTimeRequest) request;
        Charger charger = chargerRepository.findByChargeId(chargePoint.getChargeId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 충전기 입니다. chargerId=" + chargePoint.getChargeId()));
        log.info("PricePerTable ={}",pricePerTable.toString());
        PricePerMemberResponse pricePerMemberResponse = null;
        PricePerNonMemberPriceResponse pricePerNonMemberPrice = null;
        
        //충전기가 계시별 단가일 경우
        if(charger.getUnitPriceType() == 1) {
            pricePerMemberResponse = new PricePerMemberResponse(pricePerTable, charger);
            pricePerNonMemberPrice = new PricePerNonMemberPriceResponse(pricePerTable, charger);
        }
        //고정 단가일 경우
        else{
            float chargerPrice = priceService.getPrice(chargePoint.getChargePointId(),"1",null);
            pricePerMemberResponse = PricePerMemberResponse.fixedMemberPrice(chargerPrice);
            pricePerNonMemberPrice = PricePerNonMemberPriceResponse.fixedNonMemberPrice(chargerPrice);
        }

        return new PricePerTimeResponse(pricePerTimeRequest.getConnectorId(),pricePerMemberResponse,pricePerNonMemberPrice);
    }

    @Override
    protected boolean isSupported(String vendorId) {

        if(vendorId.equals(VendorConst.BLUENETWORKS)) // 코스텔
            return true;


        return false;
    }

    @Override
    protected String getMessageId() {
        return PRICE_PER_TIME;
    }

    @Override
    protected Class<?> getRequestClassType() {
        return PricePerTimeRequest.class;
    }

}
