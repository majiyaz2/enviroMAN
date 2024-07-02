package com.mhlongo.enviro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mhlongo.enviro.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    // Used an optional because it can contain an empty result
    Optional<Item> findItemById(Long itemId);
    List<Item> findByContentContaining(String word);
    Item[] findAllItems();
} 