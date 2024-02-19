package kr.dbinc.evon.ocpp.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.dbinc.evon.domain.member.Car;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


    Optional<Car> findByIdToken(String idToken);
}
