package com.example.gira.service;

import com.example.gira.model.entity.Category;
import com.example.gira.model.entity.Item;
import com.example.gira.model.service.ItemServiceModel;
import com.example.gira.repository.CategoryRepository;
import com.example.gira.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void add(ItemServiceModel itemServiceModel) {
        Item item = modelMapper.map(itemServiceModel, Item.class);

        Category category = categoryRepository.findByName(itemServiceModel.getCategory());
        item.setCategory(category);


        itemRepository.save(item);

    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item findItemByName(String name) {
        return itemRepository.findByName(name).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }
}
