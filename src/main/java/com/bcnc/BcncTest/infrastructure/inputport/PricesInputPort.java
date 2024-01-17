package com.bcnc.BcncTest.infrastructure.inputport;

import com.bcnc.BcncTest.domain.DTOs.PricesResult;

import java.time.LocalDateTime;

public interface PricesInputPort {

    PricesResult getAppliedPrice(LocalDateTime startDate, int productId, short brandId);
}
