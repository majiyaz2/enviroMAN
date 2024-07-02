package com.mhlongo.enviro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mhlongo.enviro.model.Tip;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long> {
    // Used an optional because it can contain an empty result
    Optional<Tip> findTipById(Long categoryId);
    List<Tip> findByContentContaining(String word);
    Tip[] findAllCategories();
}
