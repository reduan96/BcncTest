package com.test.HexArqTest.infrastructure;

import com.test.HexArqTest.domain.DTOs.PricesResult;
import com.test.HexArqTest.infrastructure.outputadapter.H2Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class H2RepositoryTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private H2Repository h2Repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenCorrectVarsWhenCallRepositoryGetAppliedPriceThenGetPricesResultObj() {
        LocalDateTime startDate = LocalDateTime.now();
        int productId = 1;
        int brandId = 2;
        Object[] expectedResult =
                {1, 2, 3, Timestamp.valueOf(startDate), Timestamp.valueOf(startDate.plusHours(1)), 4.5};
        Object[] finalExpectedResult = {expectedResult};

        Query query = mock(Query.class);
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(query.setParameter(anyInt(), any())).thenReturn(query);
        when(query.getResultList()).thenReturn(List.of(finalExpectedResult));

        PricesResult result = h2Repository.getAppliedPrice(startDate, productId, brandId);

        verify(entityManager).createNativeQuery(anyString());
        verify(query, times(3)).setParameter(anyInt(), any());
        verify(query, times(2)).getResultList();

        assertEquals(expectedResult[0], result.getProductId());
        assertEquals(expectedResult[1], result.getBrandId());
        assertEquals(expectedResult[2], result.getPriceList());
        assertEquals(startDate, result.getStartDate());
        assertEquals(Timestamp.valueOf(startDate.plusHours(1)).toLocalDateTime(), result.getEndDate());
        assertEquals(expectedResult[5], result.getPrice());
    }

    @Test
    void givenIncorrectVarsWhenCallRepositoryGetAppliedPriceThenNull() {

        LocalDateTime startDate = LocalDateTime.now();
        int productId = 1;
        int brandId = 2;

        Query query = mock(Query.class);
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(query.setParameter(anyInt(), any())).thenReturn(query);
        when(query.getResultList()).thenReturn(null);

        PricesResult result = h2Repository.getAppliedPrice(startDate, productId, brandId);

        verify(entityManager).createNativeQuery(anyString());
        verify(query, times(3)).setParameter(anyInt(), any());
        verify(query).getResultList();

        assertEquals(null, result);
    }
}
