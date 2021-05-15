package com.example.mockito.unit.service.impl;

import com.example.mockito.unit.model.Item;
import com.example.mockito.unit.service.IItemBusinessService;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService implements IItemBusinessService {
    @Override
    public Item retrevueHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
