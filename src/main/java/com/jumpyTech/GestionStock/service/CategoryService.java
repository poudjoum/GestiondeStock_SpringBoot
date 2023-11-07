package com.jumpyTech.GestionStock.service;

import java.util.List;

import com.jumpyTech.GestionStock.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto save(CategoryDto dto);
	CategoryDto findById(Integer id);
	List<CategoryDto> findAll();
	void delete(Integer id);
	

}
