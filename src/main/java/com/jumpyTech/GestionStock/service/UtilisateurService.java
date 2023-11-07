package com.jumpyTech.GestionStock.service;

import java.util.List;

import com.jumpyTech.GestionStock.dto.UtilisateurDto;

public interface UtilisateurService {

 
	UtilisateurDto save(UtilisateurDto dto);
	
	UtilisateurDto findById(Integer id);
	
	UtilisateurDto findByNomUtilisateur(String nomUtilisateur);
	
	List<UtilisateurDto> findAll();
	
	void delete(Integer id);
}
