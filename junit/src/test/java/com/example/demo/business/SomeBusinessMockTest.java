package com.example.demo.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusiness business = new SomeBusiness();

    @Mock
    ISomeDataService dataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{1, 2, 3});
        int result = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

}
