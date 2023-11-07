package com.jumpyTech.GestionStock.dto;

import com.jumpyTech.GestionStock.model.Roles;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {
	private Integer id;
	private String roleName;

	private UtilisateurDto utilisateur;


	public static RolesDto fromEntity(Roles r) {
		if(r==null) {
			return null;
		}
		 return RolesDto.builder()
				 .id(r.getId())
				 .roleName(r.getRoleName())
				 .utilisateur(UtilisateurDto.fromEntity(r.getUtilisateur()))
				 .build();
	}
	public static Roles toEntity(RolesDto dto) {
		if(dto==null) {
			return null;
		}
		Roles r=new Roles();
		r.setId(dto.getId());
		r.setRoleName(dto.getRoleName());
		r.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateur()));
		return r;
	}
}
