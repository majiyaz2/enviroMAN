package com.mhlongo.enviro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhlongo.enviro.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Used an optional because it can contain an empty result
    Optional<Category> findCategoryById(Long categoryId);
    List<Category> findByContentContaining(String word);
    Category[] findAllCategories();
    
}