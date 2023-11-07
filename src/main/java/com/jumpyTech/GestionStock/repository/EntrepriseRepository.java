package com.jumpyTech.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer>{

	Optional<Entreprise>findEntrepriseByNom(String nomEntreprise);
	Optional<Entreprise>findEntrepriseByRegistreCommerce(String regisCom);
	
}
