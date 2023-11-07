package com.jumpyTech.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.Utilisateurs;


public interface UtilisateurRepository extends JpaRepository<Utilisateurs,Integer>{

	Optional<Utilisateurs>findUtilisateurByNom(String nomUtilisateur);
}
