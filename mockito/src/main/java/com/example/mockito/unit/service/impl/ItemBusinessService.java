package com.example.mockito.unit.service.impl;

import com.example.mockito.unit.model.Item;
import com.example.mockito.unit.repository.ItemRepository;
import com.example.mockito.unit.service.IItemBusinessService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemBusinessService implements IItemBusinessService {

    private final ItemRepository itemRepository;

    @Override
    public Item retrevueHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @Override
    public List<Item> retrievAllItem() {
        return itemRepository.findAll();
    }
}
