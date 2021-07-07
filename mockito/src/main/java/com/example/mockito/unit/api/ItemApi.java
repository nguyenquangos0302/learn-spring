package com.example.mockito.unit.api;

import com.example.mockito.unit.model.Item;
import com.example.mockito.unit.service.IItemBusinessService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemApi {

    private final IItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retrevueHardCodedItem();
    }

    @GetMapping("/all-item")
    public List<Item> retrieveAllItem() {
        List<Item> list = itemBusinessService.retrievAllItem();
        list.forEach(data -> {
            data.setValue(data.getPrice() * data.getQuantity());
        });
        return list;
    }

}
