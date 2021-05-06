package com.example.demo.recap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AssertThatTest {

    @Test
    public void testAssertThat() throws Exception {

        int myAge = 30;

        assertThat(myAge, equalTo(30));
        assertThat(myAge, is(30));

        assertThat(myAge, not(equalTo(31)));
        assertThat(myAge, is(not(31)));

        double myMarks = 100.00;
        assertThat(myMarks, either(is(100.00)).or(is(90.9)));

        String helloTest = "Hello Test";
        double myMarks1 = 100.00;
        assertThat(helloTest, both(containsString("e")).and(containsString("t")));
        assertThat(myMarks1, both(not(90.00)).and(not(60.00)));

        double myMarks2 = 100.00;
        assertThat(myMarks2, anyOf(is(100.00), is(200.00)));
        assertThat(myMarks2, not(anyOf(is(90.00), is(200.00))));
        assertThat(myMarks2, anyOf(is(not(90.00)), is(200.00)));

        double myMarks3 = 100;
        String helloCode = "Hello Code";
        assertThat(helloCode, allOf(containsString("e"), containsString("d")));
        assertThat(myMarks3, allOf(is(103.00), is(90.00), is(100.00)));
        assertThat(myMarks3, not(allOf(is(100.00), is(90.00), is(130.00))));
    }

}
