package com.jumpyTech.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.Ventes;

public interface VenteRepository extends JpaRepository<Ventes,Integer> {
	
	Optional<Ventes> findVentesByCode(String code);

}
