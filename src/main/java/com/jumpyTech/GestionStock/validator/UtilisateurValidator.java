package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.UtilisateurDto;

public class UtilisateurValidator {
	public static List<String>validate(UtilisateurDto dto){
		List<String>errors=new ArrayList<>();

		if(dto==null) {
			errors.add("Le nom de l'utilisateur est requis");
			errors.add("Le Prenoms de l'utilisateur est requis");
			errors.add("Veuillez renseigner l'adresse de l'utilisateur");
			return errors;
		}

		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Le nom de l'utilisateur est requis");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getPrenoms())) {
			errors.add("Le Prenoms de l'utilisateur est requis");
			return errors;
		}
		if(dto.getDateNaissance()==null) {
			errors.add("La date de naissance ne peut etre vide");
			return errors;
		}
		if(dto.getAdresse()==null) {
			errors.add("Veuillez renseigner l'adresse de l'utilisateur");
			return errors;
		}else {
			if(!StringUtils.hasLength(dto.getAdresse().getAdresse1())) {
				errors.add("L'adresse1 de l'utilisateur est requise");
				return errors;
			}
			if(!StringUtils.hasLength(dto.getAdresse().getCodePostale())) {
				errors.add("Le Code postal de l'utilisateur est requis");
				return errors;
			}
			if(!StringUtils.hasLength(dto.getAdresse().getPays())) {
				errors.add("Le Pays de l'utilisateur est requis");
				return errors;
			}
			if(!StringUtils.hasLength(dto.getAdresse().getVille())) {
				errors.add("La ville de l'utilisateur est requise");
				return errors;
			}
		}


		return errors;
	}

}
