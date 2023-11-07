package com.jumpyTech.GestionStock.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.ArticleDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/articles")
public interface ArticleApi {

	@PostMapping(value=APP_ROOT+"/articles/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregistrer un article",notes="Cette methode permet d'enregistrer ou modifier un article",response=ArticleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="L'objet Article a été créer/modifier"),
			@ApiResponse(code=400,message="L'objet article n'est pas valide")
	})
	ArticleDto save(@RequestBody ArticleDto dto);
	@GetMapping(value=APP_ROOT+"/articles/{idArticle}",produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(value="Rechercher un Article",notes="Cette methode permet de chercher un article par id",response=ArticleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="L'objet Article a été trouver dans la base de données"),
			@ApiResponse(code=404,message="Aucun article n'existe avec l'id fourni")
			
	})
	ArticleDto findById(@PathVariable("idArticle")Integer id);
	
	@GetMapping(value=APP_ROOT+"/articles/{codeArticle}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Rechercher un Article",notes="Cette methode permet de chercher un article avec un code",response=ArticleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="L'objet Article a été trouver dans la base de données"),
			@ApiResponse(code=404,message="Aucun article n'existe avec le code fourni")
			
	})
	ArticleDto findByCodeArticle(@PathVariable("codeArticle")String codeArticle);
	
	@GetMapping(value=APP_ROOT+"/articles/all",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Renvoi la liste des Articles",notes="Cette methode permet de chercher et de renvoyer la liste des Articles",response=ArticleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message=" Liste des articles/ liste Vide")
	})
	List<ArticleDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/article/delete/{idArticle}")
	@ApiOperation(value="Supprimer un Article",notes="Cette methode permet de Supprimer un article par son ID",response=ArticleDto.class)
	@ApiResponses(value= {
			@ApiResponse(code=200,message="L'objet Article a été Supprimer dans la base de données"),
			@ApiResponse(code=404,message="Aucun article n'existe avec le code fourni")
			
	})
	void delete(@PathVariable("idArticle")Integer id);
}
