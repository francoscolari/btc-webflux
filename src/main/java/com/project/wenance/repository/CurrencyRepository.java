package com.project.wenance.repository;

import com.project.wenance.models.BTCEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface CurrencyRepository extends ReactiveCrudRepository<BTCEntity, Long> {

    Mono<BTCEntity> findByDate(LocalDateTime date);

    Mono<BTCEntity> findFirstByOrderByDateDesc();

    Mono<BTCEntity> findFirstByOrderByPriceDesc();

    @Query(value = "SELECT AVG(btc.price) FROM BTC_ENTITY btc WHERE btc.date  >= :dateStart  and btc.date  <= :dateEnd ")
    Mono<BigDecimal> findAvgByDateBetween(LocalDateTime dateStart, LocalDateTime dateEnd);
}
