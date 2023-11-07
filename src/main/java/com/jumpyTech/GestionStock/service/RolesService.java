package com.jumpyTech.GestionStock.service;

import java.util.List;


import com.jumpyTech.GestionStock.dto.RolesDto;

public interface RolesService {


	RolesDto save(RolesDto dto);
	
	RolesDto findById(Integer id);
	
	//RolesDto findByCodeArticle(String codeArticle);
	
	List<RolesDto> findAll();
	
	void delete(Integer id);
}
