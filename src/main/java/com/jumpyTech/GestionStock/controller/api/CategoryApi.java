package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.CategoryDto;

public interface CategoryApi {

	@PostMapping(value=APP_ROOT+"/category/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	CategoryDto save(@RequestBody CategoryDto dto);
	@GetMapping(value=APP_ROOT+"/category/{idCat}",produces=MediaType.APPLICATION_JSON_VALUE)
	CategoryDto findById(@PathVariable("idCat")Integer id);
	
	@GetMapping(value=APP_ROOT+"/category/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<CategoryDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/category/delete/{idCat}")
	void delete(@PathVariable("idCat")Integer id);
}
