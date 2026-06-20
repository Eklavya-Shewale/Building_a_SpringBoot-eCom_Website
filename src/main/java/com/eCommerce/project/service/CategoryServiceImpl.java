package com.eCommerce.project.service;

import com.eCommerce.project.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{


    private long nextID=1;
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryID(nextID);
        nextID++;
        categories.add(category);

    }

    @Override
    public String deleteCategory(long categoryID) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryID()==(categoryID))
                .findFirst().orElse(null);
        if(category == null)
        {
            return "Category Not Found";
        }
        categories.remove(category);
        return "Category with categoryID: " + categoryID + " Deleted Successfully!!";
    }
}
