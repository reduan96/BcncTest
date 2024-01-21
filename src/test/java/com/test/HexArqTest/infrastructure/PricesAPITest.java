package com.test.HexArqTest.infrastructure;

import com.test.HexArqTest.BcncTestApplication;
import com.test.HexArqTest.domain.DTOs.PricesResult;
import com.test.HexArqTest.domain.exceptions.ApiRequestException;
import com.test.HexArqTest.infrastructure.outputadapter.H2Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = BcncTestApplication.class)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class PricesAPITest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private H2Repository h2Repository;
    private PricesResult mockPricesResult;


    @BeforeEach
    public void init() {
        mockPricesResult = PricesResult.builder()
                .brandId(1)
                .startDate(LocalDateTime.parse("2020-06-14T10:00:01"))
                .endDate(LocalDateTime.parse("2020-06-14T10:00:01"))
                .priceList(1)
                .productId(111)
                .price(10.5)
                .build();
    }

    @Test
    void givenCorrectVarsWhenCallGetAppliedPriceRequestThenGetPricesResultObjTest() throws Exception {

        when(h2Repository.getAppliedPrice(LocalDateTime.parse("2020-06-14T10:00:01"), 111, 1))
                .thenReturn(mockPricesResult);

        this.mockMvc.perform(get("/prices/getAppliedPrice/2020-06-14T10:00:01/111/1")
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.brandId").value(mockPricesResult.getBrandId()))
                .andExpect(jsonPath("$.startDate").value(mockPricesResult.getStartDate().toString()))
                .andExpect(jsonPath("$.endDate").value(mockPricesResult.getEndDate().toString()))
                .andExpect(jsonPath("$.priceList").value(mockPricesResult.getPriceList()))
                .andExpect(jsonPath("$.productId").value(mockPricesResult.getProductId()))
                .andExpect(jsonPath("$.price").value(mockPricesResult.getPrice()));
    }


    @Test
    void givenIncorrectVarsWhenCallGetAppliedPriceRequestThenGetCustomException() throws Exception {

        when(h2Repository.getAppliedPrice(LocalDateTime.parse("2020-06-14T10:00:01"), 111111, 1))
                .thenThrow(new ApiRequestException("Error due inserted data"));

        this.mockMvc.perform(get("/prices/getAppliedPrice/2020-06-14T10:00:01/111111/1")
                        .accept("application/json"))
                .andExpect(status().is4xxClientError());
    }

}
