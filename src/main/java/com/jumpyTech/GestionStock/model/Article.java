package com.jumpyTech.GestionStock.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="article")
public class Article extends AbstractEntity {
	@Column(name="codeArticle")
	private String codeArticle;
	@Column(name="designation")
	private String designation;
	@Column(name="prixUnitaireHT")
	private BigDecimal prixUnitaire;
	@Column(name="TauxTVA")
	private BigDecimal tauxTva;
	@Column(name="prixUnitTTC")
	private BigDecimal prixUnitTTC;
	@Column(name="photo")
	private String photo;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category category;
}
