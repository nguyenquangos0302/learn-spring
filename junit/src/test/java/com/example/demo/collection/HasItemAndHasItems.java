package com.example.demo.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class HasItemAndHasItems {

    @Test
    public void hasItemTest() throws Exception {

        List<Double> salary = Arrays.asList(50.00, 200.00, 500.00);

        assertThat(salary, hasItem(50.00));

    }

    @Test
    public void hasItemsTest() throws Exception {

        List<Double> salary = Arrays.asList(50.00, 200.00, 500.00);

        assertThat(salary, hasItems(50.00, 200.00));

    }

}
