package com.example.demo.collection;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StartsWithAndEndsWithAndContainsString {

    @Test
    public void verify() {
        String userName = "Quang Nguyen";
        assertThat(userName, startsWith("Quang"));
        assertThat(userName, endsWith("Nguyen"));
        assertThat(userName, containsString("n"));
    }

}
