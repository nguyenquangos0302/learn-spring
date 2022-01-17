package com.example.mockito.unit.service;

import com.example.mockito.unit.service.impl.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceMockTest {

    @Mock
    private IItemBusinessService iItemBusinessService;

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Test
    public void calculateSumUsingDataService_basic() {

    }

}
