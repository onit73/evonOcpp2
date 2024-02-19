package kr.dbinc.evon.app.price.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import kr.dbinc.evon.app.price.domain.VariablePrice;
import kr.dbinc.evon.app.price.repository.VariablePriceRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VariablePriceService {


    private final VariablePriceRepository priceRepository;

    public List<VariablePrice> findAll(){
        return priceRepository.findAll();
    }

    public float getPrice(LocalDateTime dateTime) {
        VariablePrice variablePrice = getVariablePrice(dateTime.toLocalDate());
        return variablePrice.getCurrentTimePrice(dateTime.getHour());
    }

    private VariablePrice getVariablePrice(LocalDate localDate) {
        List<VariablePrice> prices = priceRepository.findAll();
        List<VariablePrice> results = prices.stream().filter(p -> p.isInclude(localDate))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            throw new IllegalStateException("VariablePrice가 1개 이상 존재해야 합니다. 현재 날짜=" + localDate);
        }

        return results.get(0);
    }


}