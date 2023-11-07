package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.ClientDto;

public class ClientValidator {
	public static List<String>validate(ClientDto dto){
		List<String> errors=new ArrayList<>();

		if(dto==null) {
			errors.add("Le nom du Client est réquis ");
			errors.add("Le prenom du Client est réquis ");
			errors.add("Le mail du Client est réquis ");
			errors.add("Le numéro de telephone du Client est réquis ");
			return errors;
		}

		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Le nom du Client est réquis ");
		}
		if(!StringUtils.hasLength(dto.getPrenoms())) {
			errors.add("Le prenom du Client est réquis ");
		}
		if(!StringUtils.hasLength(dto.getMail())) {
			errors.add("Le mail du Client est réquis ");
		}
		if(!StringUtils.hasLength(dto.getNumTel())) {
			errors.add("Le numéro de telephone du Client est réquis ");
		}
		return errors;

	}

}
