package com.jumpyTech.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.CommandeFournisseur;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {

	Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
