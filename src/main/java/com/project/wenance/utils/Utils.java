package com.project.wenance.utils;

import com.project.wenance.models.BTCEntity;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.MathContext;

public class Utils {

    public static Mono<BigDecimal> calculatePercentageDifference(Mono<BigDecimal> num1, Mono<BTCEntity> num2) {
        return num1.zipWith(num2).map(t -> t.getT1().divide(t.getT2().getPrice(),MathContext.DECIMAL64).multiply(new BigDecimal(100)).subtract(new BigDecimal(100)));
    }

}
