package com.jumpyTech.GestionStock.dto;

import java.math.BigDecimal;

import com.jumpyTech.GestionStock.model.LigneCmndeFournisseur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class LigneCmndeFournisseurDto {

	private Integer Id;
	private ArticleDto article;

	private CommandeFournisseurDto commandeFournisseur;

	private BigDecimal quantite;

	private BigDecimal prixUnitaire;
	
	public static LigneCmndeFournisseurDto toEntity(LigneCmndeFournisseur ligneCmdeFour) {
		if(ligneCmdeFour==null) {
			return null;
		}
		return LigneCmndeFournisseurDto.builder()
				.Id(ligneCmdeFour.getId())
				.prixUnitaire(ligneCmdeFour.getPrixUnitaire())
				.quantite(ligneCmdeFour.getQuantite())
				.commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCmdeFour.getCommandeFournisseur()))
				.article(ArticleDto.fromEntity(ligneCmdeFour.getArticle()))
				.build();
		
	}
	public static LigneCmndeFournisseur fromEntity(LigneCmndeFournisseurDto dto) {
		if(dto==null) {
			return null;
		}
		LigneCmndeFournisseur licfour= new LigneCmndeFournisseur();
		licfour.setId(dto.getId());
		licfour.setQuantite(dto.getQuantite());
		licfour.setPrixUnitaire(dto.getPrixUnitaire());
		licfour.setCommandeFournisseur(CommandeFournisseurDto.toEntity(dto.getCommandeFournisseur()));
		licfour.setArticle(ArticleDto.toEntity(dto.getArticle()));
		
		return null;
	}
}
