package com.enviro.assessment.grad001.andilemhlongo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.andilemhlongo.model.CategoryModel;



@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{
    
}
