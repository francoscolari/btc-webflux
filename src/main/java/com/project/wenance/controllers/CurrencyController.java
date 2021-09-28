package com.project.wenance.controllers;

import com.project.wenance.models.BTCEntity;

import com.project.wenance.models.DetailDto;
import com.project.wenance.services.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final ICurrencyService currencyService;

    @Autowired
    public CurrencyController(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/btc")
    Mono<BTCEntity> getPrice(@RequestParam(name = "date", required = false, defaultValue = "") String date) throws ParseException {
        if (!date.equals("")) {
            return currencyService.findByDate(date);
        } else return currencyService.findLastByDate( );
    }

    @GetMapping("/btc/detail")
    Mono<DetailDto> getDetail(@RequestParam(name = "dateStart") String dateStart,
                             @RequestParam(name = "dateEnd") String dateEnd
    ) throws ParseException {
        return currencyService.findDetail(dateStart, dateEnd);
    }


}
