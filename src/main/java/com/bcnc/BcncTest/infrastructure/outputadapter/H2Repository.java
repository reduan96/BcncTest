package com.bcnc.BcncTest.infrastructure.outputadapter;

import com.bcnc.BcncTest.domain.Prices;
import com.bcnc.BcncTest.infrastructure.outportport.PricesRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class H2Repository implements PricesRepository {

    @Override
    public Prices getAppliedPrice(LocalDateTime startDate, int productId, short brandId) {
        return null;
    }
}
