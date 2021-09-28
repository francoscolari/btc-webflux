package com.project.wenance.controllers;

import com.project.wenance.models.BTCDto;
import com.project.wenance.services.ICurrencyService;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BTCClient {

    private final WebClient client;

    private final ICurrencyService currencyService;

    public BTCClient(WebClient.Builder builder, ICurrencyService currencyService) {
        this.client = builder.baseUrl("https://cex.io").build( );
        this.currencyService = currencyService;
    }

    @Scheduled(fixedDelay = 10000)
    public void runClient() {
        currencyService.save(getPrice());
    }

    public Mono<BTCDto> getPrice() {
        return this.client.get( ).uri("/api/last_price/BTC/USD").accept(MediaType.APPLICATION_JSON)
                .retrieve( )
                .bodyToMono(String.class)
                .flatMap(e -> {
                    JSONObject j = new JSONObject(e);
                    BTCDto btc = new BTCDto(j.getString("lprice"), j.getString("curr1"), j.getString("curr2"));
                    return Mono.just(btc);
                });
    }

}