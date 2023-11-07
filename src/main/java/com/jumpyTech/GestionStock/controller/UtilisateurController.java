package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.UtilisateurApi;
import com.jumpyTech.GestionStock.dto.UtilisateurDto;
import com.jumpyTech.GestionStock.service.UtilisateurService;

@RestController
public class UtilisateurController implements UtilisateurApi {
	
	private UtilisateurService userService;
	public UtilisateurController(UtilisateurService us) {
		this.userService=us;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		
		return userService.save(dto);
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		// TODO Auto-generated method stub
		return userService.findById(id);
	}

	@Override
	public UtilisateurDto findUtilisateurByNom(String nomUtilisateur) {
		// TODO Auto-generated method stub
		return userService.findByNomUtilisateur(nomUtilisateur);
	}

	@Override
	public List<UtilisateurDto> findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userService.delete(id);
	}

}
