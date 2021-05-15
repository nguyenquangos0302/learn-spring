package com.example.mockito.unit.service;

import com.example.mockito.unit.model.Item;
import org.springframework.stereotype.Service;

@Service
public interface IItemBusinessService {

    Item retrevueHardCodedItem();

}
