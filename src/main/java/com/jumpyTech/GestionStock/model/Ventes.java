package com.jumpyTech.GestionStock.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="ventes")
public class Ventes extends AbstractEntity{

	@Column(name="code")
	private String code;
	@Column(name="dateVente")
	private Instant datevente;
	@Column(name="commentaire")
	private String Commentaires;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
}
