package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.CommandeClientDto;

public interface CommandeClientControllerApi {
	

	@PostMapping(value=APP_ROOT+"/commandeClient/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	CommandeClientDto save(@RequestBody CommandeClientDto dto);
	@GetMapping(value=APP_ROOT+"/commandeClient/{idCmndeCli}",produces=MediaType.APPLICATION_JSON_VALUE)
	CommandeClientDto findById(@PathVariable("idCmndeCli")Integer id);
	
	@GetMapping(value=APP_ROOT+"/commandeClient/{codeCmndeCli}",produces=MediaType.APPLICATION_JSON_VALUE)
	CommandeClientDto findByCode(@PathVariable("codeCmndeCli")String codeArticle);
	
	@GetMapping(value=APP_ROOT+"/commandeClient/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<CommandeClientDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/commandeClient/delete/{idCmndeCli}")
	void delete(@PathVariable("idCmndeCli")Integer id);

}
