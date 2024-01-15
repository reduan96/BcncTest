package com.bcnc.BcncTest.application;

import com.bcnc.BcncTest.domain.Prices;
import com.bcnc.BcncTest.infrastructure.inputport.PricesInputPort;

import java.time.LocalDateTime;

public class PricesUseCase implements PricesInputPort {
    @Override
    public Prices getAppliedPrice(LocalDateTime startDate, int productId, short brandId) {
        return null;
    }
}
