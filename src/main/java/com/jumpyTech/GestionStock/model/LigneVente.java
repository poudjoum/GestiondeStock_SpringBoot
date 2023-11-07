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
public class LigneVente extends AbstractEntity{

	@ManyToOne
	@JoinColumn(name="idVente")
	private Ventes vente;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private Article article;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
}
