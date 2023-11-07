package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.ArticleApi;
import com.jumpyTech.GestionStock.dto.ArticleDto;
import com.jumpyTech.GestionStock.service.ArticleService;

@RestController
public class ArticleController implements ArticleApi{
	private ArticleService artService;
	@Autowired
	public ArticleController(ArticleService as) {
		this.artService=as;
	}

	@Override
	public ArticleDto save(ArticleDto dto) {
		
		return artService.save(dto);
	}

	@Override
	public ArticleDto findById(Integer id) {
		
		return artService.findById(id);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		
		return artService.findByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDto> findAll() {
		
		return artService.findAll();
	}

	@Override
	public void delete(Integer id) {
		artService.delete(id);
		
	}
	

}
