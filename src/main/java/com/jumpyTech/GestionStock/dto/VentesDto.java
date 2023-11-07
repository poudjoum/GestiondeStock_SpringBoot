package com.jumpyTech.GestionStock.dto;

import java.time.Instant;
import java.util.List;

import com.jumpyTech.GestionStock.model.Ventes;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VentesDto {
	private Integer id;
	private String code;
	private Instant datevente;
	private String Commentaires;
	private List<LigneVenteDto>ligneVente;
	public static VentesDto fromEntity(Ventes vente) {
		if(vente==null) {
			// TODO Auto-generated method stub
			return null;
		}

		return VentesDto.builder()
				.id(vente.getId())
				.code(vente.getCode())
				.datevente(vente.getDatevente())
				.Commentaires(vente.getCommentaires())
				.build();
	}
	public static Ventes toEntity(VentesDto dto) {

		if(dto==null) {
			// TODO Auto-generated method stub
			return null;
		}

		Ventes ven=new Ventes();
		ven.setId(dto.getId());
		ven.setCode(dto.getCode());
		ven.setDatevente(dto.getDatevente());
		ven.setCommentaires(dto.getCommentaires());


		return ven;
	}
}
