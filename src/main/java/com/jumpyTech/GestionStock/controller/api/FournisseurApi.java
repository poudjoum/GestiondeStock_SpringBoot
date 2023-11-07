package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.FournisseurDto;

public interface FournisseurApi {

	@PostMapping(value=APP_ROOT+"/fournisseurs/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	FournisseurDto save(@RequestBody FournisseurDto dto);
	@GetMapping(value=APP_ROOT+"/fournisseurs/{idFourni}",produces=MediaType.APPLICATION_JSON_VALUE)
	FournisseurDto findById(@PathVariable("idFourni")Integer id);
	
	@GetMapping(value=APP_ROOT+"/fournisseurs/{nomFournisseur}",produces=MediaType.APPLICATION_JSON_VALUE)
	FournisseurDto findByNom(@PathVariable("nomFournisseur")String nomFournisseur);
	
	@GetMapping(value=APP_ROOT+"/fournisseurs/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<FournisseurDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/fournisseurs/delete/{idFourni}")
	void delete(@PathVariable("idArticle")Integer id);
}
