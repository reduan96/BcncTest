package com.bcnc.BcncTest.infrastructure.inputport;

import com.bcnc.BcncTest.domain.Prices;
import java.time.LocalDateTime;

public interface PricesInputPort {

    Prices getAppliedPrice(LocalDateTime startDate, int productId, short brandId);
}
