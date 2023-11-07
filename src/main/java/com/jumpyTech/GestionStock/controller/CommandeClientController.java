package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.CommandeClientControllerApi;
import com.jumpyTech.GestionStock.dto.CommandeClientDto;
import com.jumpyTech.GestionStock.service.CommandeClientService;

@RestController
public class CommandeClientController implements CommandeClientControllerApi{

	private CommandeClientService cmdeService;
	 public CommandeClientController(CommandeClientService cs) {
		 this.cmdeService=cs;
	 }
	
	@Override
	public CommandeClientDto save(CommandeClientDto dto) {
		
		return cmdeService.save(dto);
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		
		return cmdeService.findById(id);
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		
		return cmdeService.findByCode(code);
	}

	@Override
	public List<CommandeClientDto> findAll() {
		
		return cmdeService.findAll();
	}

	@Override
	public void delete(Integer id) {
		cmdeService.delete(id);
		
	}

}
