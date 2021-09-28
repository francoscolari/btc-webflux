package com.project.wenance.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailDto {

    private BigDecimal average;

    private BigDecimal max;

    private BigDecimal percentage;
}

