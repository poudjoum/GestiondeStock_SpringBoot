package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.EntrepriseApi;
import com.jumpyTech.GestionStock.dto.EntrepriseDto;
import com.jumpyTech.GestionStock.service.EntrepriseService;

@RestController
public class EntrepriseController implements EntrepriseApi{
	private EntrepriseService entService;

	
	public EntrepriseController(EntrepriseService es) {
		this.entService=es;
	}


	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
		
		return entService.save(dto);
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		
		return entService.findById(id);
	}

	@Override
	public EntrepriseDto findByRegistreCommerce(String regisCom) {
		
		return entService.findByRegistreCommerce(regisCom);
	}

	@Override
	public EntrepriseDto findByNom(String nomEntreprise) {
		
		return entService.findByNom(nomEntreprise);
	}

	@Override
	public List<EntrepriseDto> findAll() {
		
		return entService.findAll();
	}

	@Override
	public void delete(Integer id) {
		entService.delete(id);
		
	}

}
