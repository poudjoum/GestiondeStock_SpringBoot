package com.jumpyTech.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jumpyTech.GestionStock.dto.ArticleDto;

public class ArticleValidator {
	public static List<String> validate(ArticleDto dto){
		List<String>errors=new ArrayList<>();

		if(dto==null) {
			errors.add("Veuillez renseigner le Code Article!");
			errors.add("Veuillez renseigner le Code Article!");
			errors.add("Veuillez inserer un Prix unitaire HT");
			errors.add("Veuillez inserer le Taux de la Tva appliqué à cet article");
			errors.add("Veuillez renseigner la Categorie de l'article");
			return errors;
		}

		if(!StringUtils.hasLength(dto.getCodeArticle())) {
			errors.add("Veuillez renseigner le Code Article!");
		}
		if(!StringUtils.hasLength(dto.getDesignation())) {
			errors.add("Veuillez renseigner le Code Article!");
		}
		if(dto.getPrixUnitaireHt()==null) {
			errors.add("Veuillez inserer un Prix unitaire HT");
		}
		if(dto.getTauxTva()==null) {
			errors.add("Veuillez inserer le Taux de la Tva appliqué à cet article");
		}
		if(dto.getPrixUnitaireTTC()==null) {
			errors.add("Veuillez inserer le prix de l'article");
		}
		if(dto.getTauxTva()==null) {
			errors.add("Veuillez inserer le Taux de la Tva appliqué à cet article");
		}
		if(dto.getCategory()==null) {
			errors.add("Veuillez renseigner la Categorie de l'article");
		}

		return errors;
	}

}
