package com.jumpyTech.GestionStock.model;



import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class LigneCmndeFournisseur extends AbstractEntity{

	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	@ManyToOne
	@JoinColumn(name="idCommandeFournisseur")
	private CommandeFournisseur commandeFournisseur;
	@Column(name="Quantite")
	private BigDecimal quantite;
	@Column(name="prixUnitaire")
	private BigDecimal prixUnitaire;
	@Column(name="idEntreprise")
	private Integer idEntreprise;

}
