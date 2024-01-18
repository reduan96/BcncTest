package com.test.HexArqTest.infrastructure.outportport;

import com.test.HexArqTest.domain.DTOs.PricesResult;

import java.time.LocalDateTime;

public interface PricesRepository {

    public PricesResult getAppliedPrice(LocalDateTime startDate, int productId, short brandId);
}
