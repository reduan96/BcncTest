package com.test.HexArqTest.infrastructure.outputadapter;

import com.test.HexArqTest.domain.DTOs.PricesResult;
import com.test.HexArqTest.infrastructure.outportport.PricesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Repository
public class H2Repository implements PricesRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public PricesResult getAppliedPrice(LocalDateTime startDate, int productId, int brandId) {

        String querySql = "SELECT PRODUCT_ID, BRAND_ID, PRICE_LIST, START_DATE, END_DATE, PRICE FROM PRICES " +
                "WHERE BRAND_ID = ?1 AND PRODUCT_ID = ?2 AND ?3 BETWEEN START_DATE AND END_DATE";
        Query query = entityManager.createNativeQuery(querySql);
        query.setParameter(1, brandId);
        query.setParameter(2, productId);
        query.setParameter(3, startDate);
        //We get result as an Object cause it's an Object
        Object result = query.getResultList().get(0);
        //We cast our Object to an array.
        //It's necessary for take our data retrieved from database
        Object[] finalResult = (Object[]) result;
        //We cast our object[pos] dates to timestamp
        Timestamp startDateTimestamp = (Timestamp) finalResult[3];
        Timestamp endDateTimestamp = (Timestamp) finalResult[4];

        //We construct our PricesResult object
        PricesResult prices = PricesResult.builder()
                .productId((Integer) finalResult[0])
                .brandId((Short) finalResult[1])
                .priceList((Short) finalResult[2])
                .startDate(startDateTimestamp.toLocalDateTime())
                .endDate(endDateTimestamp.toLocalDateTime())
                .price((Double) finalResult[5])
                .build();

        return prices;
    }
}
