package com.jumpyTech.GestionStock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jumpyTech.GestionStock.model.CommandeClient;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class CommandeClientDto {
	private Integer id;
	private String code;

	private Instant dateCommande;

	private ClientDto client;

	private List<LigneCmndeClientDto>ligneCmndeClient;

	public static CommandeClientDto fromEntity(CommandeClient cmdeCli) {
		if(cmdeCli==null) {
			return null;
		}
		return CommandeClientDto.builder()
				.id(cmdeCli.getId())
				.code(cmdeCli.getCode())
				.dateCommande(cmdeCli.getDateCommande())
				.client(ClientDto.fromEntity(cmdeCli.getClient()))
				.build();


	}
	public static CommandeClient toEntity(CommandeClientDto dto) {
		if(dto==null) {
			return null;
		}
		CommandeClient cl=new CommandeClient();
		cl.setId(dto.getId());
		cl.setCode(dto.getCode());
		cl.setDateCommande(dto.getDateCommande());
		cl.setClient(ClientDto.toEntity(dto.getClient()));
		return cl;
	}

}
