package com.jdc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.data.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
