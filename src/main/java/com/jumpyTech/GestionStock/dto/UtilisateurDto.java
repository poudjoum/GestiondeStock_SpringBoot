package com.jumpyTech.GestionStock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.jumpyTech.GestionStock.model.Utilisateurs;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDto {
	private Integer id;
	private String nom;

	private String prenoms;

	private Instant dateNaissance;

	private String photo;

	private AdresseDto adresse;

	private EntrepriseDto entreprise;

	private List<RolesDto>roles;

	public static UtilisateurDto fromEntity(Utilisateurs ut) {
		if(ut==null) {
			return null;
			// TODO Auto-generated method stub
		}

		return UtilisateurDto.builder()
				.id(ut.getId())
				.nom(ut.getNom())
				.prenoms(ut.getPrenoms())
				.photo(ut.getPhoto())
				.dateNaissance(ut.getDateNaissance())
				.entreprise(EntrepriseDto.fromEntity(ut.getEntreprise()))
				.adresse(AdresseDto.fromEntity(ut.getAdresse()))
				.roles(ut.getRoles()!=null?
						ut.getRoles().stream()
						.map(RolesDto::fromEntity)
						.collect(Collectors.toList()):null)
				.build();
	}

	public static Utilisateurs toEntity(UtilisateurDto dto) {
		if(dto==null) {
			return null;
			// TODO Auto-generated method stub
		}
		Utilisateurs us=new Utilisateurs();
		us.setId(dto.getId());
		us.setNom(dto.getNom());
		us.setPrenoms(dto.getPrenoms());
		us.setPhoto(dto.getPhoto());
		us.setDateNaissance(dto.getDateNaissance());
		us.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
		us.setEntreprise(EntrepriseDto.toEntity(dto.getEntreprise()));
		us.setRoles(dto.getRoles()!=null?
				dto.getRoles().stream()
				.map(RolesDto::toEntity)
				.collect(Collectors.toList()):null);

		return us;
	}
}
