package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.RolesDto;

public class RolesValidator {
	public static List<String> validate(RolesDto dto){
	List<String>errors=new ArrayList<>();

	if(dto==null) {
		errors.add("Veuillez renseigner le nom du Role!");
		return errors;
	}
	if(!StringUtils.hasLength(dto.getRoleName()))
	{
	   errors.add("Veuillez renseigner le nom du Role!");
	}
	return errors;
	}
}

