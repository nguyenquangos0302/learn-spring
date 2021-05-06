package com.example.demo.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SomeDataService implements ISomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[] {1, 2 , 3};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusiness business = new SomeBusiness();
        business.setSomeDataService(new SomeDataService());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

}
