package com.bcnc.BcncTest.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRICES")
public class Prices {

    @Id
    private short pricesId;

    private short brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private short priceList;
    private int productId;
    private short priority;
    private double price;
    private String curr;
}
