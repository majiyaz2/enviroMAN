package com.mhlongo.enviro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhlongo.enviro.model.TipModel;

@Repository
public interface TipRepository extends JpaRepository<TipModel, Long>{
    
}
