package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.EntrepriseDto;

public class EntrepriseValidator {
	
	public static List<String>validate(EntrepriseDto dto){
		List<String>errors=new ArrayList<>();

		if(dto==null) {
			errors.add("Le nom de l'entreprise est requis");
			errors.add("Le registre de commerce de l'entreprise est requis");
			errors.add("L'adresse mail de l'entreprise est requise");
			errors.add("Le numéro telephone est requis");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Le nom de l'entreprise est requis");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getRegistreCommerce())) {
			errors.add("Le registre de commerce de l'entreprise est requis");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getEmail())) {
			errors.add("L'adresse mail de l'entreprise est requise");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getTel())) {
			errors.add("Le numéro telephone est requis");
			return errors;
		}
		return errors;
	}

}
