package kr.onit.evon.ocpp.repository.transaction;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.onit.evon.domain.transaction.Transaction;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @EntityGraph(attributePaths = "authorization")
    Optional<Transaction> findTransactionAndAuthById(Long id);

}
