package com.test.HexArqTest.application;

import com.test.HexArqTest.domain.DTOs.PricesResult;
import com.test.HexArqTest.infrastructure.inputport.PricesInputPort;
import com.test.HexArqTest.infrastructure.outportport.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PricesUseCase implements PricesInputPort {

    @Autowired
    PricesRepository pricesRepository;

    @Override
    public PricesResult getAppliedPrice(LocalDateTime startDate, int productId, int brandId) {
        return pricesRepository.getAppliedPrice(startDate, productId, brandId);
    }
}
