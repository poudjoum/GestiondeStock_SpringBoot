package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.ClientApi;
import com.jumpyTech.GestionStock.dto.ClientDto;
import com.jumpyTech.GestionStock.service.ClientService;

@RestController
public class ClientController implements ClientApi{
	
	private ClientService clientService;
	
	@Autowired 
	public ClientController(ClientService cs) {
		this.clientService=cs;
	}

	@Override
	public ClientDto save(ClientDto dto) {
		
		return clientService.save(dto);
	}

	@Override
	public ClientDto findById(Integer id) {
		
		return clientService.findById(id);
	}

	@Override
	public ClientDto findByNomClient(String nomClient) {
		
		return clientService.findByNomClient(nomClient);
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return clientService.findAll();
	}

	@Override
	public void delete(Integer id) {
		clientService.delete(id);
		
	}

}
