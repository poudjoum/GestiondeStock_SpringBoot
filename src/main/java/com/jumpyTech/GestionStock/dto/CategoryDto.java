package com.jumpyTech.GestionStock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jumpyTech.GestionStock.model.Category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {

	private Integer Id;
	private String codeCategorie;

	private String designation;
	@JsonIgnore
	private List<ArticleDto>articles;

	public static CategoryDto fromEntity(Category category) {
		if(category==null) {
			return null;
		}
		return CategoryDto.builder()
				.Id(category.getId())
				.codeCategorie(category.getCodeCategorie())
				.designation(category.getDesignation())
				.build();

	}
	public static Category toEntity(CategoryDto categoryDto) {
		if(categoryDto==null) {
			return null;
		}
		Category category=new Category();
		category.setId(categoryDto.getId());
		category.setCodeCategorie(categoryDto.getCodeCategorie());
		category.setDesignation(categoryDto.getDesignation());

		return category;

	}
}
