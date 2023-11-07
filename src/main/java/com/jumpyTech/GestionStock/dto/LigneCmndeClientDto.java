package com.jumpyTech.GestionStock.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jumpyTech.GestionStock.model.LigneCmndeClient;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class LigneCmndeClientDto {

	private Integer id;
	private ArticleDto article;
	@JsonIgnore
	private CommandeClientDto commandeClient;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;

	public static LigneCmndeClientDto fromEntity(LigneCmndeClient lignCmndCli) {
		if(lignCmndCli==null) {
			return null;

		}
		return LigneCmndeClientDto.builder()
				.id(lignCmndCli.getId())
				.article(ArticleDto.fromEntity(lignCmndCli.getArticle()))
				.commandeClient(CommandeClientDto.fromEntity(lignCmndCli.getCommandeClient()))
				.quantite(lignCmndCli.getQuantite())
				.prixUnitaire(lignCmndCli.getPrixUnitaire())
				.build();
	}
	public static LigneCmndeClient toEntity(LigneCmndeClientDto dto) {
		if(dto==null) {
			return null;

		}
		LigneCmndeClient lgCdCli=new LigneCmndeClient();
		lgCdCli.setId(dto.getId());
		//lgCdCli.setArticle(ArticleDto.toEntity(dto.getArticle()));
		//lgCdCli.setCommandeClient(CommandeClientDto.toEntity(dto.getCommandeClient()));
		lgCdCli.setQuantite(dto.getQuantite());
		lgCdCli.setPrixUnitaire(dto.getPrixUnitaire());
		return lgCdCli;
	}
}
