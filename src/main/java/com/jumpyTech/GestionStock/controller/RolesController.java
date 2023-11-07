package com.jumpyTech.GestionStock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jumpyTech.GestionStock.controller.api.RolesApi;
import com.jumpyTech.GestionStock.dto.RolesDto;
import com.jumpyTech.GestionStock.service.RolesService;

@RestController
public class RolesController implements RolesApi{
	
	private RolesService roleService;
	
	public RolesController(RolesService rs) {
		this.roleService=rs;
	}
	

	@Override
	public RolesDto save(RolesDto dto) {
		
		return roleService.save(dto);
	}

	@Override
	public RolesDto findById(Integer id) {
		
		return roleService.findById(id);
	}

	@Override
	public List<RolesDto> findAll() {
		
		return roleService.findAll();
	}

	@Override
	public void delete(Integer id) {
		roleService.delete(id);
		
	}

}
