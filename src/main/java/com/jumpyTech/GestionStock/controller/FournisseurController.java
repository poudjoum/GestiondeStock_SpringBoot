package com.jumpyTech.GestionStock.controller;

import java.util.List;

import com.jumpyTech.GestionStock.controller.api.FournisseurApi;
import com.jumpyTech.GestionStock.dto.FournisseurDto;
import com.jumpyTech.GestionStock.service.FournisseurService;

public class FournisseurController implements FournisseurApi {
	private FournisseurService fourService;
	
	
	public FournisseurController(FournisseurService fs) {
		this.fourService=fs;
	}

	@Override
	public FournisseurDto save(FournisseurDto dto) {
		// TODO Auto-generated method stub
		return fourService.save(dto);
	}

	@Override
	public FournisseurDto findById(Integer id) {
		// TODO Auto-generated method stub
		return fourService.findById(id);
	}

	@Override
	public FournisseurDto findByNom(String nomFournisseur) {
		// TODO Auto-generated method stub
		return fourService.findByName(nomFournisseur);
	}

	@Override
	public List<FournisseurDto> findAll() {
		// TODO Auto-generated method stub
		return fourService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		fourService.delete(id);
	}

}
