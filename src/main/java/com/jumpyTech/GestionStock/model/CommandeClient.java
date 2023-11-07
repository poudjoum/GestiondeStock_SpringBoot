package com.jumpyTech.GestionStock.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class CommandeClient extends AbstractEntity{

	@Column(name="Code")
	private String code;
	@Column(name="DateCommande")
	private Instant dateCommande;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	@OneToMany(mappedBy="commandeClient")
	private List<LigneCmndeClient>ligneCmndeClient;
}
