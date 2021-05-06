package com.example.demo.recap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class HasItemAndHasItems {

    @Test
    public void verify() throws Exception {
        List<Double> salary = Arrays.asList(50.00, 200.00, 500.00);

        assertThat(salary, hasItem(10.00));

    }

}
