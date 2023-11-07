package com.jumpyTech.GestionStock.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.Article;

public interface ArticleRepository extends JpaRepository<Article,Integer> {

	Optional<Article> findArticleByCodeArticle(String codeArticle);
}
