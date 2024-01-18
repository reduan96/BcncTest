package com.test.HexArqTest.infrastructure.inputadapter;

import com.test.HexArqTest.domain.DTOs.PricesResult;
import com.test.HexArqTest.domain.exceptions.ApiRequestException;
import com.test.HexArqTest.infrastructure.inputport.PricesInputPort;
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
                                        @PathVariable short brandId) {
        try{
            return pricesInputPort.getAppliedPrice(startDate, productId, brandId);
        }catch (Exception e){
            throw new ApiRequestException("Error due inserted data/Price record doesn't found");
        }
    }
}
