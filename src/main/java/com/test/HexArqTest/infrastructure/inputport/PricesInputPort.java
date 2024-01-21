package com.test.HexArqTest.infrastructure.inputport;

import com.test.HexArqTest.domain.DTOs.PricesResult;

import java.time.LocalDateTime;

public interface PricesInputPort {

    PricesResult getAppliedPrice(LocalDateTime startDate, int productId, int brandId);
}
