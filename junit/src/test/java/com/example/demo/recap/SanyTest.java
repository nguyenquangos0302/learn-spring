package com.example.demo.recap;

import org.junit.*;

public class SanyTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @Test
    public void someTest() {
        System.out.println("Some Test");
    }

    @Test
    public void someTestAnother() {
        System.out.println("Some Test Another");
        Assert.assertFalse("Condtition expects false", 2 > 1);
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

}
