package com.jumpyTech.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumpyTech.GestionStock.model.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {

	Optional<CommandeClient>findCommandClientByCode(String code);
}
