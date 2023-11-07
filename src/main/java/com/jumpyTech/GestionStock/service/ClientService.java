package com.jumpyTech.GestionStock.service;

import java.util.List;


import com.jumpyTech.GestionStock.dto.ClientDto;

public interface ClientService {
 
	ClientDto save(ClientDto dto);
	
	ClientDto findById(Integer id);
	
	ClientDto findByNomClient(String nomClient);
	
	List<ClientDto> findAll();
	
	void delete(Integer id);

	
}
