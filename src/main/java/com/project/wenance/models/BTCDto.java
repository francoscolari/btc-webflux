package com.project.wenance.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BTCDto {

    private String lprice;

    private String curr1;

    private String curr2;
}