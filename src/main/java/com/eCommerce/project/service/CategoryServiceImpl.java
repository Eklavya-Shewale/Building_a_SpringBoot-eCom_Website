package com.eCommerce.project.service;

import com.eCommerce.project.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{


    private Long nextID=1L;
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
    public String deleteCategory(Long categoryID) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryID()==(categoryID))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found."));

        categories.remove(category);
        return "Category with categoryID: " + categoryID + " Deleted Successfully!!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryID) {
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryID()==(categoryID))
                .findFirst();

        if(optionalCategory.isPresent())
        {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found.");
        }

    }
}
