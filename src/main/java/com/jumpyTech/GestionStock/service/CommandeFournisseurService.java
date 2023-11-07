package com.jumpyTech.GestionStock.service;

import java.util.List;

import com.jumpyTech.GestionStock.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {


	CommandeFournisseurDto save(CommandeFournisseurDto dto);
	CommandeFournisseurDto findById(Integer id);
	CommandeFournisseurDto findByCode(String code);
	List<CommandeFournisseurDto>findAll();
	void delete(Integer id);
}
