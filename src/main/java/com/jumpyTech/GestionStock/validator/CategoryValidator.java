package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.CategoryDto;

public class CategoryValidator {
	public static List<String>validate(CategoryDto categoryDto){
	List<String>errors=new ArrayList<>();
	if(StringUtils.hasLength(categoryDto.getCodeCategorie())){
		errors.add("Veuillez entrer le Code de la catégorie");
	}
	return errors;
	}

}
