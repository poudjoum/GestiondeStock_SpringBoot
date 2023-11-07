package com.jumpyTech.GestionStock.service;

import java.util.List;

import com.jumpyTech.GestionStock.dto.VentesDto;

public interface VentesService {

	VentesDto save(VentesDto dto);
	VentesDto findById(Integer id);
	VentesDto findByCodeVente(String codeVente);
	List<VentesDto> findAll();
	void deleteById(Integer id);
}
