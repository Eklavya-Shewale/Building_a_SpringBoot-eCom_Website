package com.eCommerce.project.repositories;

import com.eCommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
