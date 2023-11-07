package com.jumpyTech.GestionStock.model;

import java.util.List;

import jakarta.persistence.Column;
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
@Table(name="categorie")
public class Category extends AbstractEntity{
	@Column(name="code")
	private String codeCategorie;
	@Column(name="designation")
	private String designation;
	@Column(name="idEntreprise")
	private Integer idEntreprise;
	@OneToMany(mappedBy="category")
	private List<Article>articles;

}
