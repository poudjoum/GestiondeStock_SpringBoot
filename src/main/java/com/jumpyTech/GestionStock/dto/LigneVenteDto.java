package com.jumpyTech.GestionStock.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jumpyTech.GestionStock.model.LigneVente;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class LigneVenteDto {

	private Integer id;
	@JsonIgnore
	private VentesDto vente;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private ArticleDto article;

	public static LigneVenteDto fromEntity(LigneVente lgv) {
		if(lgv==null) {
			return null;
		}
		return LigneVenteDto.builder()
				.id(lgv.getId())
				.vente(VentesDto.fromEntity(lgv.getVente()))
				.quantite(lgv.getQuantite())
				.prixUnitaire(lgv.getPrixUnitaire())
				.article(ArticleDto.fromEntity(lgv.getArticle()))
				.build();
	}
	public static LigneVente toEntity(LigneVenteDto dto) {
		if(dto==null) {
			return null;
		}
		LigneVente lv=new LigneVente();
		lv.setId(dto.getId());
		lv.setVente(VentesDto.toEntity(dto.getVente()));
		lv.setQuantite(dto.getQuantite());
		lv.setPrixUnitaire(dto.getPrixUnitaire());
		lv.setArticle(ArticleDto.toEntity(dto.getArticle()));
		return lv;
	}
}
