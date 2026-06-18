package com.eCommerce.project.controller;

import com.eCommerce.project.model.Category;
import com.eCommerce.project.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController
{
   @Autowired  //You can use a Constructor over here as well for 'Category Service'
   private CategoryServiceImpl CategoryService;

   @GetMapping("/api/public/categories")
   public List<Category> getAllCategories()
   {
      return CategoryService.getAllCategories();
   }

   @PostMapping("/api/public/categories")
   public String createCategory(@RequestBody Category category){
      CategoryService.createCategory(category);
      return "Category added successfully";
   }


}
