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
@Table(name="Client")
public class Client extends AbstractEntity{

	@Column(name="noms")
	private String nom;
	@Column(name="prenoms")
	private String prenoms;
	@Column(name="photo")
	private String photo;
	@Column(name="email")
	private String mail;
	@Embedded
	private Adresse adresse;
	@Column(name="telephone")
	private String numTel;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
	@OneToMany(mappedBy="client")
	private List<CommandeClient>commandeClients;
}
