package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.CategoryApi;
import com.jumpyTech.GestionStock.dto.CategoryDto;
import com.jumpyTech.GestionStock.service.CategoryService;

@RestController
public class CategoryController implements CategoryApi{
	
	private CategoryService catService;
	@Autowired
	 public CategoryController(CategoryService cs) {
		 this.catService=cs;
	 }

	@Override
	public CategoryDto save(CategoryDto dto) {
		// TODO Auto-generated method stub
		return catService.save(dto);
	}

	@Override
	public CategoryDto findById(Integer id) {
		// TODO Auto-generated method stub
		return catService.findById(id);
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return catService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		catService.delete(id);
	}

}
