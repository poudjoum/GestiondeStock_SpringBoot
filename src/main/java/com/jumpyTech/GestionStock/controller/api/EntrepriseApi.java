package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.EntrepriseDto;

public interface EntrepriseApi {
	
	@PostMapping(value=APP_ROOT+"/entreprise/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto save(@RequestBody EntrepriseDto dto);
	@GetMapping(value=APP_ROOT+"/entreprise/{idEntreprise}",produces=MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto findById(@PathVariable("idArticle")Integer id);
	
	@GetMapping(value=APP_ROOT+"/entreprise/{registreCommerce}",produces=MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto findByRegistreCommerce(@PathVariable("registreCommerce")String codeArticle);
	
	@GetMapping(value=APP_ROOT+"/entreprise/{nomEntreprise}",produces=MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto findByNom(@PathVariable("nomEntreprise")String codeArticle);
	
	@GetMapping(value=APP_ROOT+"/entreprise/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<EntrepriseDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/entreprise/delete/{idEntreprise}")
	void delete(@PathVariable("idEntreprise")Integer id);

}
