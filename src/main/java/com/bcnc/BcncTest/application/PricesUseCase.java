package com.bcnc.BcncTest.application;

import com.bcnc.BcncTest.domain.Prices;
import com.bcnc.BcncTest.infrastructure.inputport.PricesInputPort;
import com.bcnc.BcncTest.infrastructure.outportport.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PricesUseCase implements PricesInputPort {

    @Autowired
    PricesRepository pricesRepository;

    @Override
    public Prices getAppliedPrice(LocalDateTime startDate, int productId, short brandId) {
        return pricesRepository.getAppliedPrice(startDate, productId, brandId);
    }
}
