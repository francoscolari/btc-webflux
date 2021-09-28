package com.project.wenance.services;

import com.project.wenance.models.BTCDto;
import com.project.wenance.models.BTCEntity;
import com.project.wenance.models.DetailDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.ParseException;

public interface ICurrencyService {
    void save(Mono<BTCDto> btc);
    Mono<BTCEntity> findByDate(String d) throws ParseException;
    Mono<BTCEntity> findLastByDate();
    Mono<DetailDto> findDetail(String dateStart, String dateEnd);
}
