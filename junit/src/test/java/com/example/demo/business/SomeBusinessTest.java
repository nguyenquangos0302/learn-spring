package com.example.demo.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessTest {

    @Test
    public void calculateSum_basic() {
        SomeBusiness business = new SomeBusiness();
        int result = business.calculateSum(new int[] {1, 2, 3} );
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

    @Test
    public void calculateSum_zero() {
        SomeBusiness business = new SomeBusiness();
        int result = business.calculateSum(new int[] {} );
        int expectedResult = 0;
        assertEquals(expectedResult, result);
    }

}
