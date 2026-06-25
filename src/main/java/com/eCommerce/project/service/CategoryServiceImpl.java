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

        Category category=categoryRepository.findById(categoryID).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));

        categoryRepository.delete(category);
        return "Category with categoryID: " + categoryID + " Deleted Successfully!!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryID) {

        Category savedCategory=categoryRepository.findById(categoryID).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        category.setCategoryID(categoryID);
        savedCategory=categoryRepository.save(category);
        System.out.println("Category with ID: "+categoryID+" has been updated.");
        return savedCategory;


    }
}
