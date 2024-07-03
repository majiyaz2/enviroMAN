package com.enviro.assessment.grad001.andilemhlongo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.andilemhlongo.model.TipModel;


@Repository
public interface TipRepository extends JpaRepository<TipModel, Long>{
    
}
