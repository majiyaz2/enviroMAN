package com.mhlongo.enviro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhlongo.enviro.model.ItemModel;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long>{
    
}
