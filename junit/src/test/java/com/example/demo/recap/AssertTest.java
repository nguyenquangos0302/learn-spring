package com.example.demo.recap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertTest {

    @Test
    public void someTest() {
        String value = "Expect Assert Test";
        String expect = "Assert Test";
        String message = "Input Assert Test";
        assertEquals(expect, value, message);
    }

}
