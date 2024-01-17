package com.bcnc.BcncTest.infrastructure.inputadapter;

import com.bcnc.BcncTest.domain.DTOs.PricesResult;
import com.bcnc.BcncTest.infrastructure.inputport.PricesInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PricesAPI {

    @Autowired
    PricesInputPort pricesInputPort;

    @GetMapping("/helloWorld")
    public String HelloWorld() {
        return "Hello World";
    }

    @GetMapping("/getAppliedPrice/{startDate}/{productId}/{brandId}")
    public PricesResult getAppliedPrice(@PathVariable LocalDateTime startDate,
                                        @PathVariable int productId,
                                        @PathVariable short brandId){
        return pricesInputPort.getAppliedPrice(startDate, productId, brandId);
    }
}
