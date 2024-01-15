package com.bcnc.BcncTest.infrastructure.outportport;

import com.bcnc.BcncTest.domain.Prices;

import java.time.LocalDateTime;

public interface PricesRepository {

    public Prices getAppliedPrice(LocalDateTime startDate, int productId, short brandId);
}
