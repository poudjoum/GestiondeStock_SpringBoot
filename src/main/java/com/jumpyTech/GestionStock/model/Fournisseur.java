package com.jumpyTech.GestionStock.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
@Table(name="Fournisseur")
public class Fournisseur extends AbstractEntity{

	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Embedded
	private Adresse adresse;
	@Column(name="NumTel")
	private String tel;
	@Column(name="Photo")
	private String photo;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
	@Column(name="Mail")
	private String Mail;
	@OneToMany(mappedBy="fournisseur")
	private List<CommandeFournisseur>commandeFournisseur;

}
