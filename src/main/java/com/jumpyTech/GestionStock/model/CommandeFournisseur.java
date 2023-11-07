package com.jumpyTech.GestionStock.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="CommandeFournisseur")
public class CommandeFournisseur extends AbstractEntity{

	@Column(name="Code")
	private String code;
	@Column(name="dateCommande")
	private Instant dateCommande;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	@OneToMany(mappedBy="commandeFournisseur")
	private List<LigneCmndeFournisseur> ligneCmndeFournisseur;
}
