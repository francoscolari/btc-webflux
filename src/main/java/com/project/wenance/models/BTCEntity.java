package com.project.wenance.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BTCEntity {
    @Id
    @CreatedDate
    private LocalDateTime date;

    private BigDecimal price;

    public BTCEntity(BigDecimal price) {
        this.price = price;
    }
}
