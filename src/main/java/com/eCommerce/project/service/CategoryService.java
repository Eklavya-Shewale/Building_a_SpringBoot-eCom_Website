package com.eCommerce.project.service;

import com.eCommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(long categoryID);
}
