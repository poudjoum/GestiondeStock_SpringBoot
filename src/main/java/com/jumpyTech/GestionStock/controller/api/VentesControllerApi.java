package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.VentesDto;

public interface VentesControllerApi {
	

	@PostMapping(value=APP_ROOT+"/ventes/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	VentesDto save(@RequestBody VentesDto dto);
	@GetMapping(value=APP_ROOT+"/ventes/{idVente}",produces=MediaType.APPLICATION_JSON_VALUE)
	VentesDto findById(@PathVariable("idVente")Integer id);
	
	@GetMapping(value=APP_ROOT+"/ventes/{codeVente}",produces=MediaType.APPLICATION_JSON_VALUE)
	VentesDto findVentesByCodeVente(@PathVariable("codeVente")String codeArticle);
	
	@GetMapping(value=APP_ROOT+"/ventes/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<VentesDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/ventes/delete/{idVente}")
	void delete(@PathVariable("idVente")Integer id);

}
