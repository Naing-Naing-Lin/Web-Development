package com.jdc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.data.Category;
import com.jdc.repo.CategoryRepo;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepo categoryRepo;
	
	public Category save(Category category) {
		if(category.getId() == 0) {
			return create(category);
		}
		return update(category);
	}
	
	@Transactional(readOnly = true)
	public List<Category> search(){
		return categoryRepo.findAll();
	}
	
	private Category update(Category category) {
		
		return categoryRepo.findById(category.getId()).map(c -> {
			c.setName(category.getName());
			return c;
		}).orElseThrow(() -> new RuntimeException("Category Id not found."));
	}

	private Category create(Category category) {
		
		return categoryRepo.save(category);
	}

	@Transactional(readOnly = true)
	public Category findById(int id) {
		
		return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category Id not found."));
	}
}
