package com.jdc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.data.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
