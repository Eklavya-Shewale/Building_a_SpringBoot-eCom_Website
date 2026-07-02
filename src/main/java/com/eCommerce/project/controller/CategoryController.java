package com.eCommerce.project.controller;

import com.eCommerce.project.model.Category;
import com.eCommerce.project.service.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController
{
   @Autowired  //You can use a Constructor over here as well for 'Category Service'
   private CategoryServiceImpl CategoryService;

   @GetMapping("/api/public/categories")
   public ResponseEntity<List <Category>> getAllCategories()
   {
      List<Category> categories = CategoryService.getAllCategories();
      return new ResponseEntity<>(categories, HttpStatus.OK);
   }

   @PostMapping("/api/public/categories")
   public ResponseEntity<String> createCategory(@Valid @RequestBody Category category){
      CategoryService.createCategory(category);
      return new ResponseEntity<>("Category added successfully", HttpStatus.CREATED);
   }


   @DeleteMapping("/api/admin/categories/{categoryID}")
   public ResponseEntity<String> deleteCategory(@PathVariable Long categoryID){
      try{
         String status = CategoryService.deleteCategory(categoryID);
         return new ResponseEntity<>(status, HttpStatus.OK);
      }
     catch(ResponseStatusException e){
         return new ResponseEntity<>(e.getReason(), e.getStatusCode());
     }
   }

   @PutMapping("/api/public/categories/{categoryID}")
   public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                @PathVariable Long categoryID){
      try{
         Category savedCategory = CategoryService.updateCategory(category,categoryID);
         return new ResponseEntity<>("Category with category ID: "+categoryID+ "Has been updated", HttpStatus.OK);
      }catch (ResponseStatusException e)
      {
         return new ResponseEntity<>(e.getReason(), e.getStatusCode());
      }

   }
}
