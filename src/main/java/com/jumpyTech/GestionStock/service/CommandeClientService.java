package com.jumpyTech.GestionStock.service;

import java.util.List;

import com.jumpyTech.GestionStock.dto.CommandeClientDto;

public interface CommandeClientService {
	
	CommandeClientDto save(CommandeClientDto dto);
	CommandeClientDto findById(Integer id);
	CommandeClientDto findByCode(String code);
	List<CommandeClientDto>findAll();
	void delete(Integer id);

}
