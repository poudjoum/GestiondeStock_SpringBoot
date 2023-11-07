package com.jumpyTech.GestionStock.model;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse {
	@Column(name="adresse&")
	private String adresse1;
	@Column(name="adresse2")
	private String adresse2;
	@Column(name="ville")
	private String ville;
	@Column(name="codePostale")
	private String codePostale;
	@Column(name="pays")
	private String pays ;

}
