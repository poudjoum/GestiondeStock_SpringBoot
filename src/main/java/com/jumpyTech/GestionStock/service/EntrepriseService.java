package com.jumpyTech.GestionStock.service;

import java.util.List;

import com.jumpyTech.GestionStock.dto.EntrepriseDto;

public interface EntrepriseService {


	EntrepriseDto save(EntrepriseDto dto);
	
	EntrepriseDto findById(Integer id);
	
	EntrepriseDto findByNom(String nomEntreprise);
	
	EntrepriseDto findByRegistreCommerce(String registreCommerce);
	
	List<EntrepriseDto> findAll();
	
	void delete(Integer id);
}
