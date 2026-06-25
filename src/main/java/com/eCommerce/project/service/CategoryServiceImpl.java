package com.eCommerce.project.service;

import com.eCommerce.project.model.Category;
import com.eCommerce.project.repositories.CategoryRepository;
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


    //private Long nextID=1L;
    //private List<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryID(nextID++);

        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryID) {
        List<Category> categories=categoryRepository.findAll();
        Category category = categories.stream()
                .filter(c -> c.getCategoryID()==(categoryID))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found."));

        categoryRepository.delete(category);
        return "Category with categoryID: " + categoryID + " Deleted Successfully!!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryID) {
        List<Category> categories=categoryRepository.findAll();
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryID()==(categoryID))
                .findFirst();

        if(optionalCategory.isPresent())
        {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category savedCategory=categoryRepository.save(existingCategory);
            return savedCategory;
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found.");
        }

    }
}
