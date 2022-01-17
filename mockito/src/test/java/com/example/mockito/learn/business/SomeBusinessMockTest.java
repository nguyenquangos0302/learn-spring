package com.example.mockito.learn.business;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService dataService;

    @Before
    public void before() {
        business.setSomeDataService(dataService);
    }

    @Test
    public void calculateSumUsingDataServiceMock_basic() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertThat(expectedResult, equalTo(actualResult));
    }

    @Mock
    List mock;

    @Test
    public void testMultiValue() {
        when(mock.size()).thenReturn(5);
        assertThat(5, equalTo(mock.size()));
    }

    @Test
    public void testMultiValueTest() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertThat(5, equalTo(mock.size()));
        assertThat(10, equalTo(mock.size()));
    }

    @Test
    public void testReturnParame() {
        when(mock.get(0)).thenReturn("quang");
        assertThat("quang", equalTo(mock.get(0)));
    }

    @Test
    public void testReturnParameAny() {
        when(mock.get(anyInt())).thenReturn("quang");
        assertThat("quang", equalTo(mock.get(0)));
        assertThat("quang", equalTo(mock.get(1)));
    }

}
