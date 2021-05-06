package com.example.demo.recap;

import com.example.demo.exception.SomeException;
import org.junit.Test;

public class SomeExceptionTest {

    @Test(expected = SomeException.class)
    public void test() {
        throw new SomeException();
    }

}
