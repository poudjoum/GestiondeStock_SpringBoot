package com.jumpyTech.GestionStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.ArticleDto;
import com.jumpyTech.GestionStock.exception.EntityNotFoundException;
import com.jumpyTech.GestionStock.exception.ErrorCode;
import com.jumpyTech.GestionStock.exception.InvalidEntityException;
import com.jumpyTech.GestionStock.model.Article;
import com.jumpyTech.GestionStock.repository.ArticleRepository;
import com.jumpyTech.GestionStock.service.ArticleService;
import com.jumpyTech.GestionStock.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService{
	private ArticleRepository articleRepo;
	
	
	public ArticleServiceImpl(ArticleRepository articleRepo){
		this.articleRepo=articleRepo;
	}

	@Override
	public ArticleDto save(ArticleDto dto) {
	
		List<String>errors=ArticleValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Article non Valid {}",dto);
			throw new InvalidEntityException("L'article n'est pas valide ",ErrorCode.ARTICLE_NOT_VALID,errors);
		}
		Article savedArticle=articleRepo.save(ArticleDto.toEntity(dto));
		
		return ArticleDto.fromEntity(savedArticle);
	}

	@Override
	public ArticleDto findById(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			return null;
		}
		Optional<Article>article=articleRepo.findById(id);
		ArticleDto dto=ArticleDto.fromEntity(article.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Article avec l'id= "+id+" n'a été trouvé dans la base de donnée",ErrorCode.ARTICLE_NOT_FOUND)) ;
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if(!StringUtils.hasLength(codeArticle)) {
			log.error("Le  Code Article est null");
			return null;
		}
		Optional<Article>article=articleRepo.findArticleByCodeArticle(codeArticle);
		ArticleDto dto=ArticleDto.fromEntity(article.get());
		
		return Optional.of(dto).orElseThrow(()->
		new EntityNotFoundException("Aucun Article avec l'id= "+codeArticle+
				" n'a été trouvé dans la base de donnée",
				ErrorCode.ARTICLE_NOT_FOUND)) ;
	}

	@Override
	public List<ArticleDto> findAll() {
		
		return articleRepo.findAll().stream()
				.map(ArticleDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Article ID est null");
			
		}
		articleRepo.deleteById(id);
		
	}

}
