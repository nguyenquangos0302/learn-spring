package com.example.mockito.unit.service;

import com.example.mockito.unit.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IItemBusinessService {

    Item retrevueHardCodedItem();

    List<Item> retrievAllItem();

}
