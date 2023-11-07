package com.jumpyTech.GestionStock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jumpyTech.GestionStock.model.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class CommandeFournisseurDto {

	private Integer id;
	private String code;

	private Instant dateCommande;

	private FournisseurDto fournisseur;
	
	private List<LigneCmndeFournisseurDto> ligneCmndeFournisseur;

	public static CommandeFournisseurDto fromEntity(CommandeFournisseur cmdeF) {
		if(cmdeF==null) {
			return null;
		}
		return CommandeFournisseurDto.builder()
				.id(cmdeF.getId())
				.code(cmdeF.getCode())
				.dateCommande(cmdeF.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(cmdeF.getFournisseur()))
				.build();
	}
	public static CommandeFournisseur toEntity(CommandeFournisseurDto dto) {
		if(dto==null) {
			return null;
		}
		CommandeFournisseur cf=new CommandeFournisseur();
		cf.setId(dto.getId());
		cf.setCode(dto.getCode());
		cf.setDateCommande(dto.getDateCommande());
		cf.setFournisseur(FournisseurDto.toEntity(dto.getFournisseur()));
		return cf;
	}
}
