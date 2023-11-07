package com.jumpyTech.GestionStock.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="Utilisateurs")
public class Utilisateurs extends AbstractEntity{
	@Column(name="nom")
	private String nom;
	@Column(name="prenoms")
	private String prenoms;
	@Column(name="email")
	private String email;
	@Column(name="dateNaissance")
	private Instant dateNaissance;
	@Column(name="photo")
	private String photo;
	@Column(name="Motdepasse")
	private String motdepasse;
	@Embedded
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name="idEntreprise")
	private Entreprise entreprise;
	@OneToMany(mappedBy="utilisateur")
	private List<Roles>roles;

}
