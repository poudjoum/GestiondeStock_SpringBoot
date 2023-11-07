package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.VentesControllerApi;
import com.jumpyTech.GestionStock.dto.VentesDto;
import com.jumpyTech.GestionStock.service.VentesService;

@RestController
public class VentesController implements VentesControllerApi{
	
	private VentesService venteService;
	
	public VentesController(VentesService vs) {
		this.venteService=vs;
	}

	@Override
	public VentesDto save(VentesDto dto) {
		// TODO Auto-generated method stub
		return venteService.save(dto);
	}

	@Override
	public VentesDto findById(Integer id) {
		// TODO Auto-generated method stub
		return venteService.findById(id);
	}

	@Override
	public VentesDto findVentesByCodeVente(String codeVente) {
		// TODO Auto-generated method stub
		return venteService.findByCodeVente(codeVente);
	}

	@Override
	public List<VentesDto> findAll() {
		// TODO Auto-generated method stub
		return venteService.findAll();
	}

	@Override
	public void delete(Integer id) {
		venteService.deleteById(id);
	}

}
