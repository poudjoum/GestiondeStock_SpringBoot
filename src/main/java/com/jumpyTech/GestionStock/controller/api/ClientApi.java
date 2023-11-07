package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jumpyTech.GestionStock.dto.ClientDto;

public interface ClientApi {

	@PostMapping(value=APP_ROOT+"/client/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ClientDto save(@RequestBody ClientDto dto);
	@GetMapping(value=APP_ROOT+"/client/{idClient}",produces=MediaType.APPLICATION_JSON_VALUE)
	ClientDto findById(@PathVariable("idClient")Integer id);
	
	@GetMapping(value=APP_ROOT+"/client/{nomClient}",produces=MediaType.APPLICATION_JSON_VALUE)
	ClientDto findByNomClient(@PathVariable("nomClient")String nomClient);
	
	@GetMapping(value=APP_ROOT+"/clients/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<ClientDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/client/delete/{idClient}")
	void delete(@PathVariable("idClient")Integer id);

}
