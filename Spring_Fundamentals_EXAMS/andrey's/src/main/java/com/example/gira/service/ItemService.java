package com.example.gira.service;

import com.example.gira.model.entity.Item;
import com.example.gira.model.service.ItemServiceModel;

import java.util.List;

public interface ItemService {
    void add(ItemServiceModel map);

    List<Item> getAllItems();

    Item findItemByName(String name);

    void deleteById(String id);
}
