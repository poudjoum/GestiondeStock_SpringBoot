package com.jumpyTech.GestionStock.service;

import java.util.List;

import com.jumpyTech.GestionStock.dto.ArticleDto;

public interface MvtStkService {
	
	ArticleDto save(ArticleDto dto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	void delete(Integer id);

}
