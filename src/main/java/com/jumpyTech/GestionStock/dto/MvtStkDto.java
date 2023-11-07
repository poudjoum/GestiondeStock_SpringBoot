package com.jumpyTech.GestionStock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.jumpyTech.GestionStock.model.MvtStk;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class MvtStkDto {

	private Integer id;
	private Instant dateMvt;
	private BigDecimal quantite;
	private ArticleDto article;

	public static MvtStkDto fromEntity(MvtStk mvtStk) {
		if(mvtStk==null) {
			return null;
		}
		return MvtStkDto.builder()
				.id(mvtStk.getId())
				.dateMvt(mvtStk.getDateMvt())
				.quantite(mvtStk.getQuantite())
				.article(ArticleDto.fromEntity(mvtStk.getArticle()))
				.build();
	}

	public static MvtStk toEntity(MvtStkDto dto) {
		if(dto==null) {
			return null;
		}
		MvtStk ms=new MvtStk();
		ms.setId(dto.getId());
		ms.setDateMvt(dto.getDateMvt());
		ms.setQuantite(dto.getQuantite());
		ms.setArticle(ArticleDto.toEntity(dto.getArticle()));
		return ms;
	}
}
