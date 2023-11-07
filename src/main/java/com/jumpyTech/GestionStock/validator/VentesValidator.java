package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.jumpyTech.GestionStock.dto.VentesDto;

public class VentesValidator {

	public static List<String> validate(VentesDto dto){
		List<String>errors=new ArrayList<>();

		if(dto==null) {
			errors.add("Veuillez renseigner le Code Vente!");
			
		}
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Le code vente ne peut etre Null");
		}
		return errors;
	}
}
