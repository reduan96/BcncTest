package com.bcnc.BcncTest.infrastructure.outportport;

import com.bcnc.BcncTest.domain.DTOs.PricesResult;

import java.time.LocalDateTime;

public interface PricesRepository {

    public PricesResult getAppliedPrice(LocalDateTime startDate, int productId, short brandId);
}
