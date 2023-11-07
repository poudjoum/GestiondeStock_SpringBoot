package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.UtilisateurDto;

public interface UtilisateurApi {
	
	@PostMapping(value=APP_ROOT+"/utilisateurs/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDto save(@RequestBody UtilisateurDto dto);
	@GetMapping(value=APP_ROOT+"/utilisateurs/{idUser}",produces=MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDto findById(@PathVariable("idUser")Integer id);
	
	@GetMapping(value=APP_ROOT+"/utilisateurs/{nomUtilisateur}",produces=MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDto findUtilisateurByNom(@PathVariable("nomUtilisateur")String codeArticle);
	
	@GetMapping(value=APP_ROOT+"/utilisateurs/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<UtilisateurDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/utilisateurs/delete/{idUser}")
	void delete(@PathVariable("idUser")Integer id);

}
