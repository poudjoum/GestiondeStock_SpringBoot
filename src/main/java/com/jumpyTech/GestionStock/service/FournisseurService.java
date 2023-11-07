package com.jumpyTech.GestionStock.service;

import java.util.List;


import com.jumpyTech.GestionStock.dto.FournisseurDto;

public interface FournisseurService {
	
	FournisseurDto save(FournisseurDto dto);
	
	FournisseurDto findById(Integer id);
	
	FournisseurDto findByName(String nomFournisseur);
	
	List<FournisseurDto> findAll();
	
	void delete(Integer id);

}
