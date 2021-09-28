package com.project.wenance.services.impl;


import com.project.wenance.models.BTCDto;
import com.project.wenance.models.BTCEntity;
import com.project.wenance.models.DetailDto;
import com.project.wenance.repository.CurrencyRepository;
import com.project.wenance.services.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static com.project.wenance.utils.Utils.calculatePercentageDifference;

@Service
public class CurrencyService implements ICurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public void save(Mono<BTCDto> btc) {
        Mono<BTCEntity> s = currencyRepository.save(new BTCEntity(new BigDecimal(btc.block( ).getLprice( ))));
        System.out.println(s.block( ));
    }

    @Override
    public Mono<BTCEntity> findByDate(String d) throws ParseException {
        LocalDateTime value = LocalDateTime.parse(d, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return currencyRepository.findByDate(value);
    }

    @Override
    public Mono<BTCEntity> findLastByDate() {
        return currencyRepository.findFirstByOrderByDateDesc( );
    }

    @Override
    public Mono<DetailDto> findDetail(String dateStart, String dateEnd) {
        DetailDto dt = new DetailDto( );
        LocalDateTime value1 = LocalDateTime.parse(dateStart, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime value2 = LocalDateTime.parse(dateEnd, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Mono<BigDecimal> average = currencyRepository.findAvgByDateBetween(value1, value2);
        Mono<BTCEntity> maxPrice = currencyRepository.findFirstByOrderByPriceDesc( );
        average.subscribe(a -> dt.setAverage(a));
        maxPrice.subscribe(a -> dt.setMax(a.getPrice( )));
        calculatePercentageDifference(average, maxPrice).subscribe( a -> dt.setPercentage(a));

        return Mono.just(dt);
    }

}
