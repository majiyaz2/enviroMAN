package com.enviro.assessment.grad001.andilemhlongo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.andilemhlongo.model.ItemModel;



@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long>{
    
}
