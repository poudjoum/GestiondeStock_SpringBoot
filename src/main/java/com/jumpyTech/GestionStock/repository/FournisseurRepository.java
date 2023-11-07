package com.jumpyTech.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
	
	Optional<Fournisseur> findFournisseurByNom(String nomFournisseur);

}
