package kr.dbinc.evon.app.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.dbinc.evon.app.price.domain.VariablePrice;

public interface VariablePriceRepository extends JpaRepository<VariablePrice, Integer> {
}
