package com.jumpyTech.GestionStock.controller.api;

import static com.jumpyTech.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jumpyTech.GestionStock.dto.RolesDto;

public interface RolesApi {

	
	@PostMapping(value=APP_ROOT+"/roles/create/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	RolesDto save(@RequestBody RolesDto dto);
	@GetMapping(value=APP_ROOT+"/roles/{idRoles}",produces=MediaType.APPLICATION_JSON_VALUE)
	RolesDto findById(@PathVariable("idRoles")Integer id);
	
	
	@GetMapping(value=APP_ROOT+"/roles/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<RolesDto> findAll();
	@DeleteMapping(value=APP_ROOT+"/roles/delete/{idRoles}")
	void delete(@PathVariable("idRoles")Integer id);
}
