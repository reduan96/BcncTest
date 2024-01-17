package com.bcnc.BcncTest.domain.DTOs;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricesResult {
    private short brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private short priceList;
    private int productId;
    private double price;
}
