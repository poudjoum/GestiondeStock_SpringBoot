package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.FournisseurDto;

public class FournisseurValidator {

	public static List<String>validate(FournisseurDto dto){
		List<String>errors=new ArrayList<>();

		if(dto==null) {
			errors.add("Le nom de l'entreprise est requis");
			errors.add("L'adresse mail de l'entreprise est requise");
			errors.add("Le numéro telephone est requis");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Le nom du fournisseur est requis");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getMail())) {
			errors.add("L'adresse mail du fournisseur est requise");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getTel())) {
			errors.add("L'adresse mail du fournisseur est requise");
			return errors;
		}
		
		return errors;
	}
}
