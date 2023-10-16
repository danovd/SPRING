package com.example.shopping_list.service;

import com.example.shopping_list.model.entity.enums.CategoryName;
import com.example.shopping_list.model.service.ProductServiceModel;
import com.example.shopping_list.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel map);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

    void buyById(String id);

    void buyAll();
}
